package com.minshang.eps.dao;

import com.minshang.eps.entity.Roleright;

public interface RolerightMapper {
    int deleteByPrimaryKey(Integer rightid);

    int insert(Roleright record);

    int insertSelective(Roleright record);

    Roleright selectByPrimaryKey(Integer rightid);

    int updateByPrimaryKeySelective(Roleright record);

    int updateByPrimaryKey(Roleright record);
}