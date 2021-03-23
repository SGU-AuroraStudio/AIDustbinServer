package com.aurora.service.impl;

import com.aurora.dao.QNAMapper;
import com.aurora.domain.QNA;
import com.aurora.service.IQNAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QNAServiceImpl implements IQNAService {
    @Autowired
    QNAMapper qnaMapper;
    @Override
    public QNA getRandomQNA() {
        return qnaMapper.selectOneByRandom();
    }
}
