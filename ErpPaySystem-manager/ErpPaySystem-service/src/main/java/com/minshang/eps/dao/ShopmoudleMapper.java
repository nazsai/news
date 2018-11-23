package com.minshang.eps.dao;

import com.minshang.eps.entity.Shopmoudle;

public interface ShopmoudleMapper {
    int deleteByPrimaryKey(Integer shopmoudleid);

    int insert(Shopmoudle record);

    int insertSelective(Shopmoudle record);

    Shopmoudle selectByPrimaryKey(Integer shopmoudleid);

    int updateByPrimaryKeySelective(Shopmoudle record);

    int updateByPrimaryKey(Shopmoudle record);
}