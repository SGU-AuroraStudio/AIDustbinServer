package com.aurora.service.impl;

import com.aurora.dao.WasteTypeMapper;
import com.aurora.domain.WasteType;
import com.aurora.service.IWasteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Yao
 * @Date 2021/3/27 10:40
 * @Description
 */
@Service
public class WasteTypeServiceImpl implements IWasteTypeService {

    @Autowired
    WasteTypeMapper wasteTypeMapper;

    @Override
    public WasteType selectById(Integer id) {
        return wasteTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public WasteType selectByName(String name) {
        return wasteTypeMapper.selectByName(name);
    }


}
