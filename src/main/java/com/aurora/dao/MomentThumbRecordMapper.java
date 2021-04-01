package com.aurora.dao;

import com.aurora.domain.MomentThumbRecord;
import com.aurora.domain.MomentThumbRecordExample;
import java.util.List;

public interface MomentThumbRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MomentThumbRecord record);

    int insertSelective(MomentThumbRecord record);

    List<MomentThumbRecord> selectByExample(MomentThumbRecordExample example);

    MomentThumbRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MomentThumbRecord record);

    int updateByPrimaryKey(MomentThumbRecord record);
}