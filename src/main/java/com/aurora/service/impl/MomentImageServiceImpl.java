package com.aurora.service.impl;

import com.aurora.dao.MomentImageMapper;
import com.aurora.domain.MomentImage;
import com.aurora.domain.MomentImageExample;
import com.aurora.service.IMomentImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/1 19:47
 * @Description
 */
@Service
public class MomentImageServiceImpl implements IMomentImageService {
    @Autowired
    MomentImageMapper momentImageMapper;

    @Override
    public List<MomentImage> selectByMomentId(Integer momentId) {
        MomentImageExample example = new MomentImageExample();
        MomentImageExample.Criteria criteria = example.createCriteria();
        criteria.andMomentIdEqualTo(momentId);
        return momentImageMapper.selectByExample(example);
    }

    @Override
    public boolean insert(MomentImage momentImage) {
        return momentImageMapper.insert(momentImage)>0;
    }
}
