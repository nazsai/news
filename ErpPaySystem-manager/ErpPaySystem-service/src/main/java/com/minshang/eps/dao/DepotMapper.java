package com.minshang.eps.dao;

import com.minshang.eps.entity.Depot;

public interface DepotMapper {
    int deleteByPrimaryKey(Integer depotid);

    int insert(Depot record);

    int insertSelective(Depot record);

    Depot selectByPrimaryKey(Integer depotid);

    int updateByPrimaryKeySelective(Depot record);

    int updateByPrimaryKey(Depot record);
}