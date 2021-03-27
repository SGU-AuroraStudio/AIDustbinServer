package com.aurora.service;

import com.aurora.domain.QNA;

/**
 * @Author Yao
 * @Date 2021/3/23 12:09
 * @Description
 */
public interface IQNAService {
    QNA getRandomQNA();

    boolean judge(Integer id, Integer choose);

    boolean updateQNARightAddOneById(Integer id);

    boolean updateQNAWrongAddOneById(Integer id);
}
