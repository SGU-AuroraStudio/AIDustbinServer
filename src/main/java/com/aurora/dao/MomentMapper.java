package com.aurora.dao;

import com.aurora.domain.Moment;
import com.aurora.domain.MomentExample;
import com.aurora.domain.MomentWithBLOBs;
import java.util.List;

public interface MomentMapper {
    int deleteByPrimaryKey(String id);

    int insert(MomentWithBLOBs record);

    int insertSelective(MomentWithBLOBs record);

    List<MomentWithBLOBs> selectByExampleWithBLOBs(MomentExample example);

    List<Moment> selectByExample(MomentExample example);

    MomentWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MomentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MomentWithBLOBs record);

    int updateByPrimaryKey(Moment record);
}