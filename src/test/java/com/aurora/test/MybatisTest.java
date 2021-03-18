package com.aurora.test;

import com.aurora.dao.IUserDao;
import com.aurora.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession session;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("conf/mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();

    }

    @After
    public void after() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        IUserDao dao = session.getMapper(IUserDao.class);
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByIdPassword() {
        IUserDao dao = session.getMapper(IUserDao.class);
        User user = dao.findByIdPassword("aaa", "111");
        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
        IUserDao dao = session.getMapper(IUserDao.class);
        String id = "ggg";
        String password = "666";
        String name = "阿巴";
        User user = dao.findById(id);
        if(user==null) {
            Boolean res = dao.saveUser(id, password, name);
            System.out.println(res);
        }
    }
}
