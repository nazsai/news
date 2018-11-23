package com.minshang.eps.size;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minshang.eps.entity.Size;
import com.minshang.eps.service.size.SizeService;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.util.ReturnValueDomain;

@Controller
@RequestMapping("/size")
public class SizeController {

	@Resource
	private SizeService sizeService;
	
	@RequestMapping("/insert")
	public Object insert(@ModelAttribute Size size) {
		return sizeService.insert(size);
	}
	
	@RequestMapping("/delete")
	public Object delete(Integer sizeid) {
		return sizeService.delete(sizeid);
	}
	
	@RequestMapping("/update")
	public Object update(@ModelAttribute Size size) {
		return sizeService.updateByPrimaryKey(size);
	}
	
	@RequestMapping("/select")
	public Object select(@ModelAttribute PageParam<Size> pageParam,@ModelAttribute Size size) {
		pageParam.setObject(size);
		ReturnValueDomain<PageResult<Size>> ret = sizeService.selectByPage(pageParam);
		PageResult<Size> page = ret.getObject();
		return PageUtil.parseData(page.getList(), page.getTotalNum(), ret.getResultdesc());
	}
}
