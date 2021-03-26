package com.aurora.service;

import com.aurora.domain.User;

public interface IUserService {

    User findById(String id);

    User findByAccount(String account);

    User login(String id, String account, String password);

    boolean register(User user);
}
