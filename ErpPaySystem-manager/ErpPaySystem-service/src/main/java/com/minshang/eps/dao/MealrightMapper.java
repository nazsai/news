package com.minshang.eps.dao;

import com.minshang.eps.entity.Mealright;

public interface MealrightMapper {
    int deleteByPrimaryKey(Integer rigthid);

    int insert(Mealright record);

    int insertSelective(Mealright record);

    Mealright selectByPrimaryKey(Integer rigthid);

    int updateByPrimaryKeySelective(Mealright record);

    int updateByPrimaryKey(Mealright record);
}