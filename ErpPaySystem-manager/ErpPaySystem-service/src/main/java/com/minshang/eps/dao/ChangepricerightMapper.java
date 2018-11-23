package com.minshang.eps.dao;

import com.minshang.eps.entity.Changepriceright;

public interface ChangepricerightMapper {
    int deleteByPrimaryKey(Integer rightid);

    int insert(Changepriceright record);

    int insertSelective(Changepriceright record);

    Changepriceright selectByPrimaryKey(Integer rightid);

    int updateByPrimaryKeySelective(Changepriceright record);

    int updateByPrimaryKey(Changepriceright record);
}