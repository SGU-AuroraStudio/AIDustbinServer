package com.aurora.dao;

import com.aurora.domain.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}