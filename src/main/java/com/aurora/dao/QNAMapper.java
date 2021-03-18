package com.aurora.dao;

import com.aurora.domain.QNA;

public interface QNAMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QNA record);

    int insertSelective(QNA record);

    QNA selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QNA record);

    int updateByPrimaryKey(QNA record);
}