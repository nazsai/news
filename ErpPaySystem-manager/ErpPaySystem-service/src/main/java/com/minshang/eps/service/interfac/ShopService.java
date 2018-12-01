package com.minshang.eps.service.interfac;

import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.ShopVo;

public interface ShopService {

	PageResult<ShopVo> pageFind(int currPage,int pageSize,ShopVo shopVo);
}
