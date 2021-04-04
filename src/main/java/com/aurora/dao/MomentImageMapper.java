package com.aurora.dao;

import com.aurora.domain.MomentImage;
import com.aurora.domain.MomentImageExample;
import com.aurora.domain.MomentImageKey;

import java.util.List;

public interface MomentImageMapper {
    int deleteByPrimaryKey(MomentImageKey key);

    int insert(MomentImage record);

    int insertSelective(MomentImage record);

    List<MomentImage> selectByExampleWithBLOBs(MomentImageExample example);

    List<MomentImage> selectByExample(MomentImageExample example);

    MomentImage selectByPrimaryKey(MomentImageKey key);

    int updateByPrimaryKeySelective(MomentImage record);

    int updateByPrimaryKeyWithBLOBs(MomentImage record);

    int updateByPrimaryKey(MomentImage record);
}