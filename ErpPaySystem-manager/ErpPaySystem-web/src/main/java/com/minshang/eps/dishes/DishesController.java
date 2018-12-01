package com.minshang.eps.dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Dishes;
import com.minshang.eps.service.dishes.DishesService;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.util.ReturnValueDomain;

@Controller
@RequestMapping("/dishes")
public class DishesController {
	
	@Autowired
	private DishesService dishesService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object selectDishesByType(@ModelAttribute PageParam<Dishes> pageParam,@ModelAttribute Dishes dishes) {
		pageParam.setObject(dishes);
		ReturnValueDomain<PageResult<Dishes>> ret = dishesService.selectByPage(pageParam);
		PageResult<Dishes> page = ret.getObject();
		return PageUtil.parseData(page.getList(), page.getTotalNum(), ret.getResultdesc());
	}
	
}
