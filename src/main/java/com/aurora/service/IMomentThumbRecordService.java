package com.aurora.service;

import com.aurora.domain.MomentThumbRecord;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/4 12:35
 * @Description
 */
public interface IMomentThumbRecordService {
    boolean insert(MomentThumbRecord momentThumbRecord);

    boolean updateDeleted(String userId, Integer momentId);

    int selectCountByMomentId(Integer momentId);

    MomentThumbRecord selectByUserIdAndMomentId(String userId, Integer momentId);

    List<MomentThumbRecord> selectByUserId(String userId);

    List<MomentThumbRecord> selectByMomentId(Integer momentId);
}
