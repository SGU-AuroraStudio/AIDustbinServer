package com.aurora.service;

import com.aurora.domain.QNA;

public interface IQNAService {
    QNA getRandomQNA();

    boolean judge(Integer id, Integer choose);

    boolean updateQNARightAddOneById(Integer id);

    boolean updateQNAWrongAddOneById(Integer id);
}
