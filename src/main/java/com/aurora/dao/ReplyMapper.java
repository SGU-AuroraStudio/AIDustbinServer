package com.aurora.dao;

import com.aurora.domain.Reply;
import com.aurora.domain.ReplyExample;
import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExampleWithBLOBs(ReplyExample example);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
}