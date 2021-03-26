package com.aurora.service.impl;

import com.aurora.dao.UserMapper;
import com.aurora.domain.User;
import com.aurora.domain.UserExample;
import com.aurora.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findByAccount(String account){
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExampleWithBLOBs(example);
        if(users==null)
            return null;
        else
            return users.get(0);
    }

    public User selectByAccountAndPassword(String account, String password){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExampleWithBLOBs(example);
        if(users==null)
            return null;
        else
            return users.get(0);
    }

    public User selectByIdAndPassword(String id, String password){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExampleWithBLOBs(example);
        if(users==null)
            return null;
        else
            return users.get(0);
    }

    @Override
    public User login(String id, String account, String password) {
        if(password==null)
            return null;
        User user = null;
        //根据id登录
        if(id!=null)
            user = this.selectByIdAndPassword(id,password);
        //不行就根据account登录
        if(user==null && account!=null)
            user = this.selectByAccountAndPassword(account,password);
        //user!=null说明登录成功
        if(user!=null) {
            //更新最后登录时间
            user.setLastLogin(new Date());
            userMapper.updateByPrimaryKey(user);
        }
        return user;
    }

    @Override
    public boolean register(User user) {
        User tempUser = userMapper.selectByPrimaryKey(user.getId());
        //检查用户是否存在，是则返回false
        if (tempUser != null)
            return false;
        else {
            int res = userMapper.insert(user);
            return res>0;
        }
    }
}
