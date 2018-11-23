package com.minshang.eps.dishestype;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Dishestype;
import com.minshang.eps.service.dishestype.DishestypeService;
import com.minshang.eps.util.Constant;
import com.minshang.eps.util.DataUtil;
import com.minshang.eps.util.ReturnValueDomain;

@Controller
@RequestMapping("dishestype")
public class DishestypeController {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private DishestypeService dishestypeService;
	
	@Resource
	private DataUtil dataUtil;
	
	@RequestMapping("insert")
	@ResponseBody
	public Object insert(@ModelAttribute Dishestype dishestype){
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		try {
			dataUtil.refresh(Constant.DISHESTYPENAME);
		} catch (Exception e) {
			Log.error("新增菜品类别失败",e);
			return ret.setFail("新增菜品类别失败");
		}
		return ret.setSuccess("新增菜品类别成功");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(Integer dishestypeid){
		return dishestypeService.deleteByPrimaryKey(dishestypeid);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(@ModelAttribute Dishestype dishestype){
		return dishestypeService.updateByPrimaryKey(dishestype);
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Object select(@ModelAttribute Dishestype dishestype){
		return DataUtil.map.get(Constant.DISHESTYPENAME);
	}
	
}
