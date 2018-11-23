package com.minshang.eps.dao;

import java.util.List;

import com.minshang.eps.entity.Dishesdepot;
import com.minshang.eps.util.PageParam;

public interface DishesdepotMapper {
    int deleteByPrimaryKey(Integer dishesdepotid);

    int insert(Dishesdepot record);

    int insertSelective(Dishesdepot record);

    Dishesdepot selectByPrimaryKey(Integer dishesdepotid);

    int updateByPrimaryKeySelective(Dishesdepot record);

    int updateByPrimaryKey(Dishesdepot record);
    
    int changestate(Dishesdepot dishesdepot);
    
    List<Dishesdepot> selectByPage(PageParam<?> pageParam);
    
    int count();
    
    int checkrepeat(String dishesdepotname);
}