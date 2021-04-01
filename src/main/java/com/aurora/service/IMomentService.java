package com.aurora.service;

import com.aurora.domain.Moment;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/1 18:42
 * @Description
 */
public interface IMomentService {
    boolean insert(Moment moment);

    Moment selectById(Integer id);


    List<Moment> selectAll();

    boolean deleteById(Integer id);
}
