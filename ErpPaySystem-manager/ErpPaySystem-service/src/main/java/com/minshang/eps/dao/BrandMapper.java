package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.Brand;
import com.minshang.eps.vo.BrandVo;

public interface BrandMapper {
	
	/**
	 * 分页查询结果集
	 * @param currPage
	 * @param pageSize
	 * @param brandVo
	 * @return
	 */
	List<BrandVo> pageFind(@Param("currPage")int currPage, @Param("pageSize")int pageSize , @Param("brandVo")BrandVo brandVo);
	
	/**
	 * 
	 * @param brandVo
	 * @return
	 */
	int pageFindCount(@Param("brandVo")BrandVo brandVo);
	
	
	/**
	 * 查询品牌名
	 * @param brandname
	 * @return
	 */
	int getCountByBrandname(String brandname);
	
	
	
	/**
	 * 
	 * @param brandid
	 * @return
	 */
    int deleteByPrimaryKey(Integer brandid);

    /**
     * 添加品牌
     * @param record
     * @return
     */
    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer brandid);

    /**
     * 	修改品牌
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}