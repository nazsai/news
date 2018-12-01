package com.minshang.eps.service.dishes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minshang.eps.dao.DishesMapper;
import com.minshang.eps.entity.Dishes;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

@Service
@Transactional
public class DishesServiceImpl implements DishesService {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DishesMapper dishesMapper;

	@Override
	public ReturnValueDomain<PageResult<Dishes>> selectByPage(PageParam<Dishes> pageParam) {
		ReturnValueDomain<PageResult<Dishes>> ret = new ReturnValueDomain<>();
		List<Dishes> list = null;
		int count = 0;
		try {
			count = dishesMapper.count(pageParam.getObject());
			list = dishesMapper.selectByPage(pageParam);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		PageResult<Dishes> page = new PageResult<>();
		page.setList(list);
		page.setTotalNum(count);
		return ret.setSuccess("分页查询菜品成功",page);
	}

	
}
