package com.minshang.eps.dao;

import java.util.List;

import com.minshang.eps.entity.Selmeal;
import com.minshang.eps.util.PageParam;

public interface SelmealMapper {
    int deleteByPrimaryKey(Integer mealid);

    int insert(Selmeal record);

    int insertSelective(Selmeal record);

    Selmeal selectByPrimaryKey(Integer mealid);

    int updateByPrimaryKeySelective(Selmeal record);

    int updateByPrimaryKey(Selmeal record);
    
    List<Selmeal> selectByPage(PageParam<Selmeal> pageParam);
    
    int count(PageParam<Selmeal> pageParam);
}