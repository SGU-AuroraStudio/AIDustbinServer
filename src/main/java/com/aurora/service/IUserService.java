package com.aurora.service;

import com.aurora.domain.User;

/**
 * @Author Yao
 * @Date 2021/3/17 9:57
 * @Description
 */
public interface IUserService {

    User selectById(String id);

    User login(String id, String password);

    boolean register(User user);

    boolean updateById(User user);
}
