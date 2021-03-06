package com.aurora.controller;

import com.aurora.domain.Comment;
import com.aurora.domain.Moment;
import com.aurora.domain.MomentImage;
import com.aurora.domain.User;
import com.aurora.domain.base.Constants;
import com.aurora.domain.base.ResponseJSON;
import com.aurora.service.impl.CommentServiceImpl;
import com.aurora.service.impl.MomentImageServiceImpl;
import com.aurora.service.impl.MomentServiceImpl;
import com.aurora.service.impl.MomentThumbRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @Author Yao
 * @Date 2021/4/1 18:42
 * @Description
 */
@Controller
@RequestMapping("/moment")
public class MomentController {

    @Autowired
    MomentServiceImpl momentService;
    @Autowired
    MomentImageServiceImpl momentImageService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    MomentThumbRecordServiceImpl momentThumbRecordService;

    @GetMapping
    @ResponseBody
    public Map<String, Object> getMoments(HttpServletRequest request,@RequestParam Integer page) {
        Integer limit=5;                   //查询条数，每页默认为5
        int offset= limit*(page-1);        //起始位置

        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        List<Moment> moments = momentService.selectByLimit(offset, limit);
        for (Moment moment : moments) {
            //把图片链接拼接进去
            List<String> imagesUrl = new LinkedList<>();
            for(int i=1;i<=moment.getImageCount();i++)
                imagesUrl.add(Constants.SERVER_BASE_HTTP_URL + "/moment/image/"+moment.getId()+"/"+i);
            moment.setImagesUrl(imagesUrl);
            //把评论拼接到JSON里。减少前台请求次数
            List<Comment> tempComments = commentService.selectByMomentId(moment.getId());
            List<Comment> comments = new ArrayList<>();
            Map<Integer,Comment> commentMap = new HashMap<>();
            //因为是共用一个表，所以评论和回复都被获取下来，此时在同一级，根据baseCommentId给回复分配到Comment里
            //一级评论的baseCommentId默认为0，更多级的不为零
            for (Comment comment : tempComments) {
                if(comment.getBaseCommentId()==0){
                    commentMap.put(comment.getId(), comment);
                }
            }
            for (Comment reply : tempComments) {
                if(reply.getBaseCommentId()!=0){
                    Comment newComment = commentMap.get(reply.getBaseCommentId());
                    newComment.addReply(reply);
                }
            }
            Set<Integer> keySet = commentMap.keySet();
            for (Integer key : keySet) {
                comments.add(commentMap.get(key));
            }
            moment.setComments(comments);
            //总点赞数
            moment.setThumbCount(momentThumbRecordService.selectCountByMomentId(moment.getId()));
            //用户是否点赞
            moment.setThumbed(momentThumbRecordService.selectByUserIdAndMomentId(user.getId(), moment.getId()) != null);
        }
        return ResponseJSON.SUCCESS.getJSON(moments);
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteMoment(HttpServletRequest request, Integer id) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Moment moment = momentService.selectById(id);
        //检查登录人id和动态的发表人id是否相同，不同就不给操作
        if (!moment.getUserId().equals(user.getId()))
            return ResponseJSON.FAIL.getJSON();
        if (momentService.deleteById(id))
            return ResponseJSON.SUCCESS.getJSON();
        else
            return ResponseJSON.FAIL.getJSON();
    }

    @PostMapping
    @ResponseBody
    public Map<String, Object> addMoment(HttpServletRequest request, @RequestParam(value = "content") String content, MultipartFile[] images) throws IOException {
        if (images != null && images.length > 9)
            return ResponseJSON.MAX_FILE_COUNT_ERROR.getJSON();
        //插入动态内容
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Moment moment = new Moment(user.getId(), content, 0, new Date());
        moment.setUserNickname(user.getNickname());
        moment.setUserProfile(user.getProfile());
        // moment分两次插入
        // 第一次插入获取momentID，在xml里需要设置useGeneratedKeys="true" keyProperty="id"获取自增的id，否者为null
        momentService.insert(moment);
        int no = 0;
        //插入图片
        if (images != null && images.length > 0) {
            for (MultipartFile image : images) {
                //文件这么小，肯定不是图片(10B)
                if (image.getSize() < 10) continue;
                MomentImage momentImage = new MomentImage(null, ++no, moment.getId(), new Date(), image.getBytes());
                if (!momentImageService.insert(momentImage))
                    return ResponseJSON.FAIL.getJSON();
            }
        }
        //第二次更新图片数量
        moment.setImageCount(no);
        momentService.updateByIdSelective(moment);
        return ResponseJSON.SUCCESS.getJSON(moment);
    }
}
