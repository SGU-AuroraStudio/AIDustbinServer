package com.aurora.dao;

import com.aurora.domain.MomentImage;
import com.aurora.domain.MomentImageExample;
import java.util.List;

public interface MomentImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MomentImage record);

    int insertSelective(MomentImage record);

    List<MomentImage> selectByExampleWithBLOBs(MomentImageExample example);

    List<MomentImage> selectByExample(MomentImageExample example);

    MomentImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MomentImage record);

    int updateByPrimaryKeyWithBLOBs(MomentImage record);

    int updateByPrimaryKey(MomentImage record);
}