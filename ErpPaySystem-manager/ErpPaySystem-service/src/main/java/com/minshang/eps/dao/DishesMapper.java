package com.minshang.eps.dao;

import java.util.List;

import com.minshang.eps.entity.Dishes;
import com.minshang.eps.util.PageParam;

public interface DishesMapper {
    int deleteByPrimaryKey(Integer dishesid);

    int insert(Dishes record);

    int insertSelective(Dishes record);

    Dishes selectByPrimaryKey(Integer dishesid);

    int updateByPrimaryKeySelective(Dishes record);

    int updateByPrimaryKey(Dishes record);
    
    List<Dishes> selectByPage(PageParam<Dishes> pageParam);
    
    int count(Dishes dishes);
}