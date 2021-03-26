package com.aurora.dao;

import com.aurora.domain.User;
import com.aurora.domain.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

//    User selectByIdAndPassword(@Param("id") String id, @Param("password")String password);
//
//    User selectByAccountAndPassword(@Param("account") String account, @Param("password")String password);

    List<User> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}