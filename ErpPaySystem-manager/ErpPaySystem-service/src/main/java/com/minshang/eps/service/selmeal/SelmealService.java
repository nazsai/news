package com.minshang.eps.service.selmeal;

import com.minshang.eps.entity.Selmeal;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

public interface SelmealService {
	
	ReturnValueDomain<PageResult<Selmeal>> selectByPage(PageParam<Selmeal> pageParam);
}
