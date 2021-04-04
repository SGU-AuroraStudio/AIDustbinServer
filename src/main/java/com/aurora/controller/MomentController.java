package com.aurora.controller;

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
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> getMoments(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        List<Moment> moments = momentService.selectAll();
        for (Moment moment : moments) {
            //把评论拼接到JSON里。减少前台请求次数
            moment.setComments(commentService.selectByMomentId(moment.getId()));
            //总点赞数
            moment.setThumbCount(momentThumbRecordService.selectCountByMomentId(moment.getId()));
            //用户是否点赞
            moment.setThumbed(momentThumbRecordService.selectByUserIdAndMomentId(user.getId(), moment.getId()) != null);
        }
        return ResponseJSON.SUCCESS.getJSON(moments);
    }

    @PostMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteMoment(HttpServletRequest request, Integer id) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Moment moment = momentService.selectById(id);
        //检查登录人id和动态的发表人id是否相同，不同就不给操作
        if (moment.getUserId().equals(user.getId()))
            return ResponseJSON.FAIL.getJSON();
        if (momentService.deleteById(id))
            return ResponseJSON.SUCCESS.getJSON();
        else
            return ResponseJSON.FAIL.getJSON();
    }

    @PostMapping
    @ResponseBody
    public Map<String, Object> addMoment(HttpServletRequest request, @RequestParam(value = "content") String content, MultipartFile[] images) throws IOException {
        if (images.length > 9)
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
                if (image.getSize() < 10)
                    continue;
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
