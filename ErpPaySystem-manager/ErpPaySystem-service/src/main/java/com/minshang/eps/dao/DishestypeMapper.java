package com.minshang.eps.dao;

import java.util.List;

import com.minshang.eps.entity.Dishestype;

public interface DishestypeMapper {
    int deleteByPrimaryKey(Integer dishestypeid);

    int insert(Dishestype record);

    int insertSelective(Dishestype record);

    Dishestype selectByPrimaryKey(Integer dishestypeid);

    int updateByPrimaryKeySelective(Dishestype record);

    int updateByPrimaryKey(Dishestype record);
    
    List<Dishestype> select(Dishestype record);
}