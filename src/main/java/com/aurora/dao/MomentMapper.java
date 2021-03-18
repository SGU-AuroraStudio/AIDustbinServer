package com.aurora.dao;

import com.aurora.domain.Moment;
import com.aurora.domain.MomentWithBLOBs;

public interface MomentMapper {
    int deleteByPrimaryKey(String id);

    int insert(MomentWithBLOBs record);

    int insertSelective(MomentWithBLOBs record);

    MomentWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MomentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MomentWithBLOBs record);

    int updateByPrimaryKey(Moment record);
}