package com.minshang.eps.selmeal;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Selmeal;
import com.minshang.eps.service.selmeal.SelmealService;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.util.ReturnValueDomain;

@Controller
@RequestMapping("/selmeal")
public class SelmealController {
	
	@Resource
	private SelmealService selmealService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object selectByPage(@ModelAttribute PageParam<Selmeal> pageParam,@ModelAttribute Selmeal sealmeal) {
		pageParam.setObject(sealmeal);
		ReturnValueDomain<PageResult<Selmeal>> ret = selmealService.selectByPage(pageParam);
		PageResult<Selmeal> page = ret.getObject();
		return PageUtil.parseData(page.getList(), page.getTotalNum(), ret.getResultdesc());
	}
	
}
