package com.aurora.dao;

import com.aurora.domain.Moment;
import com.aurora.domain.MomentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MomentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Moment record);

    int insertSelective(Moment record);

    List<Moment> selectByExample(MomentExample example);

    List<Moment> selectByLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Moment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Moment record);

    int updateByPrimaryKey(Moment record);

    int updateUserByUserId(Moment record);
}