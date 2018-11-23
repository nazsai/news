package com.minshang.eps.dao;

import com.minshang.eps.entity.Statictype;

public interface StatictypeMapper {
    int deleteByPrimaryKey(Integer statictypeid);

    int insert(Statictype record);

    int insertSelective(Statictype record);

    Statictype selectByPrimaryKey(Integer statictypeid);

    int updateByPrimaryKeySelective(Statictype record);

    int updateByPrimaryKey(Statictype record);
}