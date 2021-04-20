package com.aurora.service.impl;

import com.aurora.dao.CommentMapper;
import com.aurora.domain.Comment;
import com.aurora.domain.CommentExample;
import com.aurora.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/2 17:34
 * @Description 评论和回复共用一个业务层、数据库表。评论为两级评论
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insertSelective(comment) > 0;
    }

    @Override
    public boolean updateFromUserByUserId(Comment comment) {
        return commentMapper.updateFromUserByUserId(comment) > 0;
    }

    @Override
    public boolean deleteCommentById(Integer id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setDeleted(true);
        return commentMapper.updateByPrimaryKeySelective(comment) > 0;
    }

    @Override
    public Comment selectById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> selectByMomentId(Integer momentId) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andMomentIdEqualTo(momentId)
                .andDeletedEqualTo(false);
        ArrayList<Comment> comments = (ArrayList<Comment>) commentMapper.selectByExample(example);
        return comments;
    }

    @Override
    public Comment selectByIdAndMomentId(Integer id, Integer momentId) {
        CommentExample example = new CommentExample();
        example.createCriteria().andIdEqualTo(id)
                .andMomentIdEqualTo(momentId)
                .andDeletedEqualTo(false);
        List<Comment> list = commentMapper.selectByExample(example);
        if (list.size() == 0)
            return null;
        return list.get(0);
    }


}
