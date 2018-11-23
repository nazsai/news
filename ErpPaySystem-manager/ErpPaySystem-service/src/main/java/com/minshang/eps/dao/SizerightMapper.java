package com.minshang.eps.dao;

import com.minshang.eps.entity.Sizeright;

public interface SizerightMapper {
    int deleteByPrimaryKey(Integer rightid);

    int insert(Sizeright record);

    int insertSelective(Sizeright record);

    Sizeright selectByPrimaryKey(Integer rightid);

    int updateByPrimaryKeySelective(Sizeright record);

    int updateByPrimaryKey(Sizeright record);
    
    int deleteBySizeid(Integer sizeid);
}