package com.aurora.dao;

import com.aurora.domain.QNA;
import com.aurora.domain.QNAExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QNAMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QNA record);

    int insertSelective(QNA record);

    List<QNA> selectByExample(QNAExample example);

    QNA selectOneByRandom();

    QNA selectByPrimaryKey(Integer id);

    int updateRightById(@Param("id") Integer id, @Param("valueToAdd") Integer valueToAdd);

    int updateWrongById(@Param("id") Integer id, @Param("valueToAdd") Integer valueToAdd);

    int updateByPrimaryKeySelective(QNA record);

    int updateByPrimaryKey(QNA record);
}