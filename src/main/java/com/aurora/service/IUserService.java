package com.aurora.service;

import com.aurora.domain.User;
import java.util.List;

public interface IUserService {

    User findById(String id);

    User login(String id,String password);

    boolean register(String id,String password,String name);
}
