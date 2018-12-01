package com.minshang.eps.service.interfac;

import com.minshang.eps.entity.Shopmoudle;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

/**
 * 	权限模板业务层接口
 * @author Administrator
 *
 */
public interface ShopmoudleService {

//	ReturnValueDomain<PageResult<Shopmoudle>> pageFind(PageParam<?> pageParam);
	
	PageResult<Shopmoudle> pageFind(int currPage, int pageSize ,Shopmoudle shopmoudle);
	
}
