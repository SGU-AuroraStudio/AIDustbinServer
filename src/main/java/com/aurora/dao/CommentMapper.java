package com.aurora.dao;

import com.aurora.domain.Comment;
import com.aurora.domain.CommentExample;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    int updateThisAndSonDeletedToTrue(Integer id);
}