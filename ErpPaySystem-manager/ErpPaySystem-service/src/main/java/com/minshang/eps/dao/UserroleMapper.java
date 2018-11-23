package com.minshang.eps.dao;

import com.minshang.eps.entity.Userrole;

public interface UserroleMapper {
    int deleteByPrimaryKey(Integer userroleid);

    int insert(Userrole record);

    int insertSelective(Userrole record);

    Userrole selectByPrimaryKey(Integer userroleid);

    int updateByPrimaryKeySelective(Userrole record);

    int updateByPrimaryKey(Userrole record);
}