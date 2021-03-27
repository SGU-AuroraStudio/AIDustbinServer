package com.aurora.dao;

import com.aurora.domain.WasteType;

public interface WasteTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WasteType record);

    int insertSelective(WasteType record);

    WasteType selectByName(String name);

    WasteType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WasteType record);

    int updateByPrimaryKey(WasteType record);
}