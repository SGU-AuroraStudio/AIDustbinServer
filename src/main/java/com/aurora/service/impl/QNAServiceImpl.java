package com.aurora.service.impl;

import com.aurora.dao.QNAMapper;
import com.aurora.domain.QNA;
import com.aurora.domain.QNAExample;
import com.aurora.service.IQNAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QNAServiceImpl implements IQNAService {
    @Autowired
    QNAMapper qnaMapper;
    @Override
    public QNA getRandomQNA() {
        return qnaMapper.selectOneByRandom();
    }

    @Override
    public boolean judge(Integer id, Integer choose) {
        QNAExample example = new QNAExample();
        QNAExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andAnswerEqualTo(choose);
        List<QNA> list = qnaMapper.selectByExample(example);
        return list != null;
    }

    @Override
    public boolean updateQNARightAddOneById(Integer id){
        return qnaMapper.updateRightById(id,1)>0;
    }

    @Override
    public boolean updateQNAWrongAddOneById(Integer id) {
        return qnaMapper.updateWrongById(id, 1)>0;
    }
}