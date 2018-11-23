package com.minshang.eps.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.minshang.eps.entity.Dishestype;
import com.minshang.eps.service.dishestype.DishestypeService;

@Service
public class DishestypeInit {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private DishestypeService dishestypeService;
	
	private  Map<String,String> map = new HashMap<>();
	
	public Map<String,String> init(){
		Log.debug("菜品类型初始化开始");
		ReturnValueDomain<List<Dishestype>> ret = dishestypeService.select(null);
		List<Dishestype> list = ret.getObject();
		for (Dishestype dishestype : list) {
			map.put(dishestype.getDishestypeid().toString(), dishestype.getDishestypename());
		}
		Log.debug("菜品类型初始化结束");
		return map;
	}
}
