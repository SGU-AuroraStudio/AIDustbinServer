package com.aurora.service.impl;

import com.aurora.dao.MomentThumbRecordMapper;
import com.aurora.domain.MomentThumbRecord;
import com.aurora.domain.MomentThumbRecordExample;
import com.aurora.service.IMomentThumbRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/4 12:36
 * @Description
 */
@Service
public class MomentThumbRecordServiceImpl implements IMomentThumbRecordService {
    @Autowired
    MomentThumbRecordMapper momentThumbRecordMapper;

    @Override
    public boolean insert(MomentThumbRecord momentThumbRecord) {
        return momentThumbRecordMapper.insertSelective(momentThumbRecord) > 0;
    }

    @Override
    public boolean updateDeleted(String userId, Integer momentId) {
        MomentThumbRecord momentThumbRecord = this.selectByUserIdAndMomentId(userId, momentId);
        if (momentThumbRecord == null)
            return false;
        else
            return momentThumbRecordMapper.updateDeletedReverseById(momentThumbRecord.getId()) > 0;
    }

    @Override
    public int selectCountByMomentId(Integer momentId) {
        return momentThumbRecordMapper.selectCountByMomentId(momentId);
    }

    @Override
    public MomentThumbRecord selectByUserIdAndMomentId(String userId, Integer momentId) {
        MomentThumbRecordExample example = new MomentThumbRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andMomentIdEqualTo(momentId)
                .andDeletedEqualTo(false);
        List<MomentThumbRecord> list = momentThumbRecordMapper.selectByExample(example);
        if (list.size() == 0)
            return null;
        else
            return list.get(0);
    }

    /**
     * 根据用户查询点赞的动态
     *
     * @param userId userId
     * @return List
     */
    @Override
    public List<MomentThumbRecord> selectByUserId(String userId) {
        MomentThumbRecordExample example = new MomentThumbRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andDeletedEqualTo(false);
        return momentThumbRecordMapper.selectByExample(example);
    }

    /**
     * 根据动态id查询点赞记录
     *
     * @param momentId momentId
     * @return
     */
    @Override
    public List<MomentThumbRecord> selectByMomentId(Integer momentId) {
        MomentThumbRecordExample example = new MomentThumbRecordExample();
        example.createCriteria()
                .andMomentIdEqualTo(momentId)
                .andDeletedEqualTo(false);
        return momentThumbRecordMapper.selectByExample(example);
    }
}
