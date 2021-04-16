package com.aurora.service.impl;

import com.aurora.dao.MomentImageMapper;
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
    @Autowired
    MomentImageMapper momentImageMapper;

    @Override
    public boolean insert(Moment moment) {
        return momentMapper.insertSelective(moment) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        Moment moment = new Moment();
        moment.setId(id);
        moment.setDeleted(true);
        return momentMapper.updateByPrimaryKeySelective(moment) > 0;
    }

    @Override
    public boolean updateByIdSelective(Moment moment) {
        return momentMapper.updateByPrimaryKeySelective(moment) > 0;
    }

    @Override
    public boolean updateUserByUserId(Moment moment) {
        return momentMapper.updateUserByUserId(moment) > 0;
    }

    @Override
    public Moment selectById(Integer id) {
        //查询所有动态 moments
        MomentExample example = new MomentExample();
        MomentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andDeletedEqualTo(false);
        List<Moment> list = momentMapper.selectByExample(example);
        if(list.size()==0)
            return null;
        return list.get(0);
    }

    @Override
    public List<Moment> selectAll() {
        //查询所有动态 moments
        MomentExample example = new MomentExample();
        MomentExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        List<Moment> moments = momentMapper.selectByExample(example);
        return moments;
    }
}
