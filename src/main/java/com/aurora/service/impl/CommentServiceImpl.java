package com.aurora.service.impl;

import com.aurora.dao.CommentMapper;
import com.aurora.domain.Comment;
import com.aurora.domain.CommentExample;
import com.aurora.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/2 17:34
 * @Description
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insertSelective(comment) > 0;
    }

    /**
     * 删除评论，和评论下的回复
     *
     * @param id 评论id
     * @return true/false
     */
    @Override
    public boolean deleteById(Integer id) {

        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andDeletedEqualTo(false);
        List<Comment> list = commentMapper.selectByExample(example);

        if (list.size() == 0)
            return false;

        return false;
    }

    @Override
    public boolean deleteThisAndSonById(Integer id) {
        return commentMapper.updateThisAndSonDeletedToTrue(id) > 0;
    }

    @Override
    public Comment selectById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> selectByMomentId(Integer momentId) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andMomentIdEqualTo(momentId);
        criteria.andDeletedEqualTo(false);
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment selectByIdAndMomentId(Integer id, Integer momentId) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andMomentIdEqualTo(momentId);
        criteria.andDeletedEqualTo(false);
        List<Comment> list = commentMapper.selectByExample(example);
        if (list.size() == 0)
            return null;
        return list.get(0);
    }


}
