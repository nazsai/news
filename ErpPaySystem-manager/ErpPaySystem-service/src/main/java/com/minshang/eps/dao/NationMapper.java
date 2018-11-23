package com.minshang.eps.dao;

import com.minshang.eps.entity.Nation;

public interface NationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);
}