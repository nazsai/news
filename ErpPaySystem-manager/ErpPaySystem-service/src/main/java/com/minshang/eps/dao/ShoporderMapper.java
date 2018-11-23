package com.minshang.eps.dao;

import com.minshang.eps.entity.Shoporder;

public interface ShoporderMapper {
    int deleteByPrimaryKey(Integer shoporderid);

    int insert(Shoporder record);

    int insertSelective(Shoporder record);

    Shoporder selectByPrimaryKey(Integer shoporderid);

    int updateByPrimaryKeySelective(Shoporder record);

    int updateByPrimaryKey(Shoporder record);
}