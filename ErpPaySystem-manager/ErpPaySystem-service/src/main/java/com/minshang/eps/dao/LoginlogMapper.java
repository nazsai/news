package com.minshang.eps.dao;

import com.minshang.eps.entity.Loginlog;

public interface LoginlogMapper {
    int deleteByPrimaryKey(Integer loginid);

    int insert(Loginlog record);

    int insertSelective(Loginlog record);

    Loginlog selectByPrimaryKey(Integer loginid);

    int updateByPrimaryKeySelective(Loginlog record);

    int updateByPrimaryKey(Loginlog record);
}