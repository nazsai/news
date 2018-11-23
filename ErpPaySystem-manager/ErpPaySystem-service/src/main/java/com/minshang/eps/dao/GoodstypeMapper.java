package com.minshang.eps.dao;

import com.minshang.eps.entity.Goodstype;

public interface GoodstypeMapper {
    int deleteByPrimaryKey(Integer goodstypeid);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);

    Goodstype selectByPrimaryKey(Integer goodstypeid);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);
}