package com.minshang.eps.dao;

import com.minshang.eps.entity.Practice;

public interface PracticeMapper {
    int deleteByPrimaryKey(Integer practiceid);

    int insert(Practice record);

    int insertSelective(Practice record);

    Practice selectByPrimaryKey(Integer practiceid);

    int updateByPrimaryKeySelective(Practice record);

    int updateByPrimaryKey(Practice record);
}