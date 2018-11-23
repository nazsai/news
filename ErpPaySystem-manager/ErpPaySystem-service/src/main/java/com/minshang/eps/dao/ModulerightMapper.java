package com.minshang.eps.dao;

import com.minshang.eps.entity.Moduleright;

public interface ModulerightMapper {
    int deleteByPrimaryKey(Integer modulerightid);

    int insert(Moduleright record);

    int insertSelective(Moduleright record);

    Moduleright selectByPrimaryKey(Integer modulerightid);

    int updateByPrimaryKeySelective(Moduleright record);

    int updateByPrimaryKey(Moduleright record);
}