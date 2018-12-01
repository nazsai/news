package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.Shopmoudle;
import com.minshang.eps.util.PageParam;

public interface ShopmoudleMapper {
	
//	List<Shopmoudle> pageFind(PageParam<?> pageParam);
	
	List<Shopmoudle> pageFind(@Param("currPage")int currPage, @Param("pageSize")int pageSize, @Param("shopmoudle")Shopmoudle shopmoudle);
	
//	int pageFindCount();
	
	int pageFindCount(@Param("shopmoudle")Shopmoudle shopmoudle);
	
	
    int deleteByPrimaryKey(Integer shopmoudleid);

    int insert(Shopmoudle record);

    int insertSelective(Shopmoudle record);

    Shopmoudle selectByPrimaryKey(Integer shopmoudleid);

    int updateByPrimaryKeySelective(Shopmoudle record);

    int updateByPrimaryKey(Shopmoudle record);
}