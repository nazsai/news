package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.Area;
import com.minshang.eps.vo.AreaVo;

public interface AreaMapper {
	
	
	/**
	 * 分页查询结果集
	 * @param currPage
	 * @param pageSize
	 * @param brandVo
	 * @return
	 */
	List<AreaVo> pageFind(@Param("currPage")int currPage, @Param("pageSize")int pageSize , @Param("areaVo")AreaVo areaVo);
	
	/**
	 * 查询总行数
	 * @param brandVo
	 * @return
	 */
	int pageFindCount(@Param("areaVo")AreaVo areaVo);
	
	
	/**
	 * 查询
	 * @param brandname	品牌名称
	 * @param dcname	地区名
	 * @return
	 */
	int getCountByName(String brandname , String dcname);
	
	/**
	 * 删除地区
	 * @param areaid
	 * @return
	 */
    int deleteByPrimaryKey(Integer areaid);

    /**
     * 添加地区
     * @param area
     * @return
     */
    void addArea(AreaVo areaVo);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaid);

    /**
     * 修改地区
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AreaVo areaVo);

    int updateByPrimaryKey(Area record);
}