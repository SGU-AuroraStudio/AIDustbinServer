package com.aurora.dao;

import com.aurora.domain.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
}