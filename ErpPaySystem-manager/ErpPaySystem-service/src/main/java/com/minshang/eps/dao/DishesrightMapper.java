package com.minshang.eps.dao;

import com.minshang.eps.entity.Dishesright;

public interface DishesrightMapper {
    int deleteByPrimaryKey(Integer rightid);

    int insert(Dishesright record);

    int insertSelective(Dishesright record);

    Dishesright selectByPrimaryKey(Integer rightid);

    int updateByPrimaryKeySelective(Dishesright record);

    int updateByPrimaryKey(Dishesright record);
}