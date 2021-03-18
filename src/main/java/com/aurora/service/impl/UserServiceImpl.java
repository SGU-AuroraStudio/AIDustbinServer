package com.aurora.service.impl;

import com.aurora.dao.IUserDao;
import com.aurora.domain.User;
import com.aurora.service.IUserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceImpl implements IUserService {

    SqlSession sqlSession;
    IUserDao dao;

    public UserServiceImpl(SqlSession sqlSession) throws IOException {
        this.sqlSession = sqlSession;
        dao = sqlSession.getMapper(IUserDao.class);
    }

    @Override
    public User findById(String id) {
        return dao.findById(id);
    }

    @Override
    public User login(String id, String password) {
        return dao.findByIdPassword(id, password);
    }

    @Override
    public boolean register(String id, String password, String name) {
        return dao.saveUser(id, password, name);
    }
}
