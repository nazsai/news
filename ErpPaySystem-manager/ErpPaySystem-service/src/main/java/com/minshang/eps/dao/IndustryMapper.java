package com.minshang.eps.dao;



import java.util.List;

import com.minshang.eps.entity.Industry;

public interface IndustryMapper {
	
	List<Industry> findList();
	
    int deleteByPrimaryKey(Integer industryid);

    int insert(Industry record);

    int insertSelective(Industry record);

    Industry selectByPrimaryKey(Integer industryid);

    int updateByPrimaryKeySelective(Industry record);

    int updateByPrimaryKey(Industry record);
}