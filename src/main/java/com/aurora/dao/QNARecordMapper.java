package com.aurora.dao;

import com.aurora.domain.QNARank;
import com.aurora.domain.QNARecord;
import com.aurora.domain.QNARecordExample;
import java.util.List;

public interface QNARecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QNARecord record);

    int insertSelective(QNARecord record);

    List<QNARank> selectQNARank();

    List<QNARecord> selectByExample(QNARecordExample example);

    QNARecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QNARecord record);

    int updateByPrimaryKey(QNARecord record);
}