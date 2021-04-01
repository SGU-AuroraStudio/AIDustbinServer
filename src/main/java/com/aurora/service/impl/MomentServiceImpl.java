package com.aurora.service.impl;

import com.aurora.dao.MomentMapper;
import com.aurora.domain.Moment;
import com.aurora.domain.MomentExample;
import com.aurora.service.IMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/1 18:43
 * @Description
 */
@Service
public class MomentServiceImpl implements IMomentService {
    @Autowired
    MomentMapper momentMapper;

    @Override
    public boolean insert(Moment moment) {
        return momentMapper.insertSelective(moment)>0;
    }

    @Override
    public Moment selectById(Integer id) {
        return momentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Moment> selectAll() {
        MomentExample example = new MomentExample();
        MomentExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return momentMapper.selectByExample(example);
    }

    @Override
    public boolean deleteById(Integer id) {
        return momentMapper.deleteByPrimaryKey(id)>0;
    }
}
