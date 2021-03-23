package com.aurora.dao;

import com.aurora.domain.QNA;
import com.aurora.domain.QNAExample;
import java.util.List;

public interface QNAMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QNA record);

    int insertSelective(QNA record);

    QNA selectOneByRandom();

    List<QNA> selectByExample(QNAExample example);

    QNA selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QNA record);

    int updateByPrimaryKey(QNA record);
}