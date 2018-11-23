package com.minshang.eps.dishes;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Dishes;
import com.minshang.eps.util.Constant;
import com.minshang.eps.util.DataUtil;
import com.minshang.eps.util.PageParam;

@Controller
@RequestMapping("/dishes")
public class DishesController {
	
	
	
	
	@RequestMapping("/list")
	@ResponseBody
	public Object selectDishesByType(@ModelAttribute PageParam<Dishes> pageParam,@ModelAttribute Dishes dishes) {
		Integer dishestypeid = dishes.getDishesid();
		Map<?, ?> map = DataUtil.map.get(Constant.DISHESTYPENAME);
		if(map.get(dishestypeid.toString()).equals("套餐")) {
			
		}
		return null;
	}
	
}
