package com.aurora.service;

import com.aurora.domain.QNARank;
import com.aurora.domain.QNARecord;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/3/27 10:30
 * @Description
 */
public interface IQNARecordService {
    boolean insertOne(QNARecord qnaRecord);

    List<QNARank> selectQNARank();
}
