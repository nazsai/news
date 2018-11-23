package com.minshang.eps.service.interfac;

import com.minshang.eps.entity.Brand;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;
import com.minshang.eps.vo.BrandVo;

/**
 * 品牌业务层接口
 * @author Administrator
 *
 */
public interface BrandService {

	PageResult<BrandVo> pageFind(int currPage, int pageSize , BrandVo brandVo);
	
	String checkBrandname(String brandname);
	
	void addBrand(Brand brand);
	
	void updateBrand(Brand brand);
	
	void deleteBrand(int brandid);
	
	
	
}
