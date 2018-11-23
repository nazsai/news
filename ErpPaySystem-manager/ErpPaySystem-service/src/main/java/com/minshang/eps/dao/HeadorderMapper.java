package com.minshang.eps.dao;

import com.minshang.eps.entity.Headorder;

public interface HeadorderMapper {
    int deleteByPrimaryKey(Integer shoporderid);

    int insert(Headorder record);

    int insertSelective(Headorder record);

    Headorder selectByPrimaryKey(Integer shoporderid);

    int updateByPrimaryKeySelective(Headorder record);

    int updateByPrimaryKey(Headorder record);
}