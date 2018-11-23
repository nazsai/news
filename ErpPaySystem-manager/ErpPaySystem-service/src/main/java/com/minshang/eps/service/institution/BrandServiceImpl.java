package com.minshang.eps.service.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.BrandMapper;
import com.minshang.eps.entity.Brand;
import com.minshang.eps.service.interfac.BrandService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.BrandVo;

/**
 * 品牌业务层
 * @author Administrator
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;
	
	@Override
	public PageResult<BrandVo> pageFind(int currPage, int pageSize,
			BrandVo brandVo) {
		
		List<BrandVo> list = this.brandMapper.pageFind(currPage, pageSize, brandVo);

	    int totalNum = this.brandMapper.pageFindCount(brandVo);

	    return new PageResult<BrandVo>(Integer.valueOf(currPage), Integer.valueOf(pageSize), Integer.valueOf(totalNum), list);
	}

	@Override
	public String checkBrandname(String brandname) {
		int count = this.brandMapper.getCountByBrandname(brandname);
	    if (count > 0) {
	      return "该品牌名称已存在！！";
	    }
	    return "y";	
	}

	@Override
	public void addBrand(Brand brand) {
		this.brandMapper.insert(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		this.brandMapper.updateByPrimaryKeySelective(brand);
	}

	@Override
	public void deleteBrand(int brandid) {
		this.brandMapper.deleteByPrimaryKey(brandid);
	}

}
