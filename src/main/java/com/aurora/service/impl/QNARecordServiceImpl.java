package com.aurora.service.impl;

import com.aurora.dao.QNARecordMapper;
import com.aurora.domain.QNARank;
import com.aurora.domain.QNARecord;
import com.aurora.service.IQNARecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/3/27 10:30
 * @Description
 */
@Service
public class QNARecordServiceImpl implements IQNARecordService {

    @Autowired
    QNARecordMapper qnaRecordMapper;

    @Override
    public boolean insert(QNARecord qnaRecord) {
        return qnaRecordMapper.insert(qnaRecord) > 0;
    }

    @Override
    public List<QNARank> selectQNARank() {
        return qnaRecordMapper.selectQNARank();
    }

}
