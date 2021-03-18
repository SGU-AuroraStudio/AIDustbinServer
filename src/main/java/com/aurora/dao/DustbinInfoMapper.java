package com.aurora.dao;

import com.aurora.domain.DustbinInfo;

public interface DustbinInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DustbinInfo record);

    int insertSelective(DustbinInfo record);

    DustbinInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DustbinInfo record);

    int updateByPrimaryKey(DustbinInfo record);
}