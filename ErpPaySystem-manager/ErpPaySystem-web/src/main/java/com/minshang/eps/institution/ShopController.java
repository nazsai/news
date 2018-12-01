package com.minshang.eps.institution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.service.interfac.ShopService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.vo.ShopVo;

@Controller
@RequestMapping("/institution")
public class ShopController {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/shopList")
	@ResponseBody
	public Object pageFind(
			@RequestParam(defaultValue = "1", required = false) Integer currPage,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			ShopVo shopVo
			) {
		PageResult<ShopVo> page = shopService.pageFind(currPage, pageSize, shopVo);
		return PageUtil.parseData(page.getList(), page.getTotalNum(), "查询成功");
	}
}
