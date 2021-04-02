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
    public MomentImage selectByMomentIdAndImageNo(Integer momentId, Integer imageNo) {
        MomentImageExample example = new MomentImageExample();
        MomentImageExample.Criteria criteria = example.createCriteria();
        criteria.andMomentIdEqualTo(momentId);
        criteria.andImageNoEqualTo(imageNo);
        List<MomentImage> momentImages = momentImageMapper.selectByExampleWithBLOBs(example);
        if(momentImages.size()==0)
            return null;
        return momentImages.get(0);
    }

    @Override
    public boolean insert(MomentImage momentImage) {
        return momentImageMapper.insert(momentImage)>0;
    }
}
