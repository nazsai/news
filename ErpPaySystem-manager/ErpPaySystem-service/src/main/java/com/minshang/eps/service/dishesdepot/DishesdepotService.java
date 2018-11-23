package com.minshang.eps.service.dishesdepot;

import com.minshang.eps.entity.Dishesdepot;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;


public interface DishesdepotService {
	
	ReturnValueDomain<String> insert(Dishesdepot dishesdepot);
	
	ReturnValueDomain<String> changestate(Dishesdepot dishesdepot);
	
	ReturnValueDomain<PageResult<Dishesdepot>> selectByPage(PageParam<?> pageParam);
}
