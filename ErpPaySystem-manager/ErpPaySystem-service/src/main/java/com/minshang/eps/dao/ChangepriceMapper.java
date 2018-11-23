package com.minshang.eps.dao;

import com.minshang.eps.entity.Changeprice;

public interface ChangepriceMapper {
    int deleteByPrimaryKey(Integer changepriceid);

    int insert(Changeprice record);

    int insertSelective(Changeprice record);

    Changeprice selectByPrimaryKey(Integer changepriceid);

    int updateByPrimaryKeySelective(Changeprice record);

    int updateByPrimaryKey(Changeprice record);
}