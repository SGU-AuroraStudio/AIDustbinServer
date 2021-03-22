package com.aurora.dao;

import com.aurora.domain.DustbinInfo;
import com.aurora.domain.DustbinInfoExample;
import java.util.List;

public interface DustbinInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DustbinInfo record);

    int insertSelective(DustbinInfo record);

    List<DustbinInfo> selectByExample(DustbinInfoExample example);

    DustbinInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DustbinInfo record);

    int updateByPrimaryKey(DustbinInfo record);
}