package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.Shop;
import com.minshang.eps.vo.ShopVo;

public interface ShopMapper {
	
	List<ShopVo> pageFind(@Param("currPage")int currPage, @Param("pageSize")int pageSize,@Param("shopVo")ShopVo shopVo);
	
	int pageFindCount(@Param("shopVo")ShopVo shopVo);
	
    int deleteByPrimaryKey(Integer shopid);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shopid);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}