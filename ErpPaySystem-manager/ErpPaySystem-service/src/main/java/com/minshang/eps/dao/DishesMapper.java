package com.minshang.eps.dao;

import com.minshang.eps.entity.Dishes;

public interface DishesMapper {
    int deleteByPrimaryKey(Integer dishesid);

    int insert(Dishes record);

    int insertSelective(Dishes record);

    Dishes selectByPrimaryKey(Integer dishesid);

    int updateByPrimaryKeySelective(Dishes record);

    int updateByPrimaryKey(Dishes record);
}