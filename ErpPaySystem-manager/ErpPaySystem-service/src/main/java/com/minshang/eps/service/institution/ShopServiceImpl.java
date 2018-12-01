package com.minshang.eps.service.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.ShopMapper;
import com.minshang.eps.service.interfac.ShopService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.ShopVo;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopMapper shopMapper;

	@Override
	public PageResult<ShopVo> pageFind(int currPage, int pageSize, ShopVo shopVo) {
		List<ShopVo> list = this.shopMapper.pageFind(currPage, pageSize, shopVo);
		int totalNum = this.shopMapper.pageFindCount(shopVo);
		return new PageResult<ShopVo>(currPage, pageSize, totalNum, list);
	}

}
