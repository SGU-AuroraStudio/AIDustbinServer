package com.aurora.dao;

import com.aurora.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{arg0}")
    User findById(String id);

    @Select("select * from user where id=#{arg0} and password=#{arg1}")
    User findByIdPassword(String id,String password);

    @Insert("insert into user(id,password,name) values(#{arg0},#{arg1},#{arg2})")
    boolean saveUser(String id,String password,String name);
}
