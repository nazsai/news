package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.Depot;

public interface DepotMapper {
	/**
	 * 分页查询结果集
	 * @param currPage 当前页
	 * @param pageSize 每页行数
	 * @param depot 查询条件
	 * @return
	 */
	List<Depot>pageFind(@Param("currPage") int currPage,
	                    @Param("pageSize") int pageSize,@Param("depot") Depot depot);
	/**
	 * 查询结果集
	 * @param depot
	 * @return
	 */
	int pageFindCount(@Param("depot") Depot depot);
	
	/***
	 * 增加一个仓库记录
	 * @param depot
	 */
	void addDepot(Depot depot);
	/**
	 * 根据用户民查询条数
	 * @param depotname
	 * @return
	 */
	int getCountByDepotname(String depotname);
	
	
	
    int deleteByPrimaryKey(Integer depotid);

    int insert(Depot record);

    int insertSelective(Depot record);

    Depot selectByPrimaryKey(Integer depotid);

    int updateByPrimaryKeySelective(Depot record);

    int updateByPrimaryKey(Depot record);
}