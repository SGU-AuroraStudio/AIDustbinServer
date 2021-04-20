package com.aurora.controller;

import com.aurora.domain.Comment;
import com.aurora.domain.Moment;
import com.aurora.domain.User;
import com.aurora.domain.base.CommentType;
import com.aurora.domain.base.Constants;
import com.aurora.domain.base.ResponseJSON;
import com.aurora.service.impl.CommentServiceImpl;
import com.aurora.service.impl.MomentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/4/2 18:35
 * @Description
 */
@Controller
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    MomentServiceImpl momentService;

    @GetMapping
    @ResponseBody
    public Map<String, Object> getComments(Integer momentId) {
        List<Comment> comments = commentService.selectByMomentId(momentId);
        if (comments.size() == 0)
            return ResponseJSON.FAIL.getJSON();
        else
            return ResponseJSON.SUCCESS.getJSON(comments);
    }

    @PostMapping("/moment/comment/delete")
    @ResponseBody
    public Map<String, Object> deleteComment(HttpServletRequest request, Integer commentId) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Comment comment = commentService.selectById(commentId);
        if (!user.getId().equals(comment.getFromUserId()))
            return ResponseJSON.FAIL.getJSON();
        commentService.deleteCommentById(commentId);
        return ResponseJSON.SUCCESS.getJSON();
    }

    /**
     * 评论和回复的控制器分开。不分开也可以
     * 评论功能，一级评论
     *
     */
    @PostMapping("/moment/comment")
    @ResponseBody
    public Map<String, Object> addComment(HttpServletRequest request,@RequestParam Integer momentId,@RequestParam String content) {
        //判断动态是否存在
        Moment moment = momentService.selectById(momentId);
        if (moment == null)
            return ResponseJSON.MOMENT_NOT_FOUND.getJSON();
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Comment comment = new Comment(user.getId(), user.getNickname(), user.getProfile(), momentId, content, null, null,new Date());
        if(commentService.insert(comment))
            return ResponseJSON.SUCCESS.getJSON();
        else
            return ResponseJSON.FAIL.getJSON();
    }

    /**
     * 回复功能，即二级评论，评论别人的评论，最高二级，用@表示更高级的。类似微信朋友圈。
     * @param momentId momentId。可以根据baseCommentId获取的，但是要多连接一次数据库，浪费。
     * @param baseCommentId 在哪个评论下面
     * @param pid 回复哪个二级评论。带pid的是3级或更高级评论
     * @param content 内容
     * @return
     */
    @PostMapping("/moment/reply")
    @ResponseBody
    public Map<String, Object> addReply(HttpServletRequest request,@RequestParam Integer momentId,@RequestParam Integer baseCommentId, Integer pid,@RequestParam String content) {
        //判断动态是否存在
        Moment moment = momentService.selectById(momentId);
        if (moment == null)
            return ResponseJSON.MOMENT_NOT_FOUND.getJSON();

        //判断评论是否存在
        Comment baseComment = commentService.selectById(baseCommentId);
        if(baseComment == null)
            return ResponseJSON.COMMENT_NOT_FOUND.getJSON();

        //判断要回复的回复是否存在
        //pid是parentId，目标应该是评论下的回复。有pid表示@某人
        if(pid!=null){
            Comment targetReply = commentService.selectByIdAndMomentId(pid, momentId);
            if(targetReply==null)
                return ResponseJSON.COMMENT_NOT_FOUND.getJSON();
            if(targetReply.getBaseCommentId()==0)
                return ResponseJSON.FAIL.getJSON();
        }

        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Comment reply = new Comment(user.getId(), user.getNickname(), user.getProfile(), momentId, content, baseCommentId, pid, new Date());
        if(commentService.insert(reply))
            return ResponseJSON.SUCCESS.getJSON();
        else
            return ResponseJSON.FAIL.getJSON();
    }

}
