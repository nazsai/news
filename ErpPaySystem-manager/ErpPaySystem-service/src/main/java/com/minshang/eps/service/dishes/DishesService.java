package com.minshang.eps.service.dishes;

import com.minshang.eps.entity.Dishes;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

public interface DishesService {
	
	ReturnValueDomain<PageResult<Dishes>> selectByPage(PageParam<Dishes> pageParam);
}
