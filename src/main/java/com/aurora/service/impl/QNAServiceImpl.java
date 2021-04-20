package com.aurora.service.impl;

import com.aurora.dao.QNAMapper;
import com.aurora.domain.QNA;
import com.aurora.domain.QNAExample;
import com.aurora.service.IQNAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/3/23 12:09
 * @Description
 */
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
        example.createCriteria()
                .andIdEqualTo(id)
                .andAnswerEqualTo(choose);
        List<QNA> list = qnaMapper.selectByExample(example);
        return list.size() > 0;
    }

    @Override
    public boolean updateQNARightAddOneById(Integer id) {
        return qnaMapper.updateRightById(id, 1) > 0;
    }

    @Override
    public boolean updateQNAWrongAddOneById(Integer id) {
        return qnaMapper.updateWrongById(id, 1) > 0;
    }
}
