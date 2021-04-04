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
@RequestMapping("/moment/comment")
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

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteComment(HttpServletRequest request, Integer commentId) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Comment comment = commentService.selectById(commentId);
        if (!user.getId().equals(comment.getFromUserId()))
            return ResponseJSON.FAIL.getJSON();
        commentService.deleteThisAndSonById(commentId);
        return ResponseJSON.SUCCESS.getJSON();
    }

    @PostMapping
    @ResponseBody
    public Map<String, Object> addComment(HttpServletRequest request, Integer momentId, @RequestParam(value = "toCommentId", required = false) Integer toCommentId, String content) {
        //判断动态是否存在
        Moment moment = momentService.selectById(momentId);
        if (moment == null)
            return ResponseJSON.FAIL.getJSON();

        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Comment comment;
        //评论分为comment和reply
        //目标评论Id为空，说明是评论动态的，类型为comment
        if (toCommentId == null) {
            comment = new Comment(user.getId(), momentId, content, null, CommentType.comment, new Date());
        } else {
            //判断目标评论是否存在，类型为reply
            Comment comment1 = commentService.selectByIdAndMomentId(toCommentId, momentId);
            if (comment1 == null)
                return ResponseJSON.COMMENT_NOT_FOUNT.getJSON();
            comment = new Comment(user.getId(), momentId, content, toCommentId, CommentType.reply, new Date());
        }
        comment.setFromUserNickname(user.getNickname());
        comment.setFromUserProfile(user.getProfile());
        //插入，在xml里需要设置useGeneratedKeys="true" keyProperty="id"获取自增的id，否者为null
        if (commentService.insert(comment))
            return ResponseJSON.SUCCESS.getJSON(comment);
        else
            return ResponseJSON.FAIL.getJSON();
    }

}
