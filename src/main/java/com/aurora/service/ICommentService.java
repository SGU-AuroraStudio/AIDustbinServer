package com.aurora.service;

import com.aurora.domain.Comment;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/2 17:33
 * @Description
 */
public interface ICommentService {
    boolean insert(Comment comment);

    boolean deleteThisAndSonById(Integer id);

    Comment selectById(Integer id);

    List<Comment> selectByMomentId(Integer momentId);

    Comment selectByIdAndMomentId(Integer id, Integer momentId);


}
