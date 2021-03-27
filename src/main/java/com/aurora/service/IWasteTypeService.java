package com.aurora.service;

import com.aurora.domain.WasteType;

/**
 * @Author Yao
 * @Date 2021/3/27 10:40
 * @Description
 */
public interface IWasteTypeService {
    WasteType selectById(Integer id);

    WasteType selectByName(String name);
}
