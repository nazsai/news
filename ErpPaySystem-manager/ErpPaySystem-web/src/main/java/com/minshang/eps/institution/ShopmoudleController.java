package com.minshang.eps.institution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Shopmoudle;
import com.minshang.eps.service.interfac.ShopmoudleService;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.util.ReturnValueDomain;

@Controller
@RequestMapping("/institution")
public class ShopmoudleController {

	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ShopmoudleService shopmoudleService;
	
//	@RequestMapping("/shopmoudleList")
//	@ResponseBody
//	public Object pageFind(@ModelAttribute PageParam<Shopmoudle> pageParam,@ModelAttribute Shopmoudle shopmoudle) {
//		Log.debug("页码{}，每页显示{}",pageParam.getCurrPage(),pageParam.getPageSize());
//		pageParam.setObject(shopmoudle);
//		ReturnValueDomain<PageResult<Shopmoudle>> ret = shopmoudleService.pageFind(pageParam);
//		PageResult<Shopmoudle> page = ret.getObject();
//				return PageUtil.parseData(page.getList(), page.getTotalNum(), ret.getResultdesc());
//	}
	
	@RequestMapping("/shopmoudleList")
	@ResponseBody
	public Object pageFind(
			@RequestParam(defaultValue = "1", required = false) Integer currPage,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			Shopmoudle shopmoudle
			) {
		PageResult<Shopmoudle> page = shopmoudleService.pageFind(currPage, pageSize, shopmoudle);
		return PageUtil.parseData(page.getList(), page.getTotalNum(), "查询成功");
	}
}
