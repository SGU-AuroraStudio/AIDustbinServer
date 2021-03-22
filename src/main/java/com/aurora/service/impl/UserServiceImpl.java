package com.aurora.service.impl;

import com.aurora.dao.UserMapper;
import com.aurora.domain.User;
import com.aurora.domain.UserExample;
import com.aurora.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User login(String id, String password) {
        return userMapper.selectByIdAndPassword(new User(id,password));
    }

    @Override
    public boolean register(String id, String password, String name) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null)
            return false;
        else {
            int res = userMapper.insert(new User(id,password,name));
            return res>0;
        }
    }
}
