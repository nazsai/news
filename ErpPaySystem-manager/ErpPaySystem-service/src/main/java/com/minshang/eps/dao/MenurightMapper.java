package com.minshang.eps.dao;

import com.minshang.eps.entity.Menuright;

public interface MenurightMapper {
    int deleteByPrimaryKey(Integer rightid);

    int insert(Menuright record);

    int insertSelective(Menuright record);

    Menuright selectByPrimaryKey(Integer rightid);

    int updateByPrimaryKeySelective(Menuright record);

    int updateByPrimaryKey(Menuright record);
}