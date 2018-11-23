package com.minshang.eps.dao;

import com.minshang.eps.entity.Error;

public interface ErrorMapper {
    int deleteByPrimaryKey(String errorcode);

    int insert(Error record);

    int insertSelective(Error record);

    Error selectByPrimaryKey(String errorcode);

    int updateByPrimaryKeySelective(Error record);

    int updateByPrimaryKey(Error record);
}