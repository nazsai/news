package com.minshang.eps.dao;

import com.minshang.eps.entity.Staticdata;

public interface StaticdataMapper {
    int deleteByPrimaryKey(Integer staticdataid);

    int insert(Staticdata record);

    int insertSelective(Staticdata record);

    Staticdata selectByPrimaryKey(Integer staticdataid);

    int updateByPrimaryKeySelective(Staticdata record);

    int updateByPrimaryKey(Staticdata record);
}