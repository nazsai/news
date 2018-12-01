package com.minshang.eps.institution;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Brand;
import com.minshang.eps.entity.User;
import com.minshang.eps.service.interfac.BrandService;
import com.minshang.eps.service.interfac.IndustryService;
import com.minshang.eps.util.Constant;
import com.minshang.eps.util.DataUtil;
import com.minshang.eps.util.MyofficeConstants;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.vo.BrandVo;

/**
 * 品牌控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/institution")
public class BrandController {

	@Autowired
	public BrandService brandService;
	@Autowired
	public IndustryService industryService;
	
	
	@RequestMapping("/pageFindBrand")
	@ResponseBody
	public Object pageFind(
			@RequestParam(defaultValue = "1", required = false) Integer currPage,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			BrandVo brandVo) {
		PageResult<BrandVo> page = brandService.pageFind(currPage, pageSize, brandVo);
		return PageUtil.parseData(page.getList(), page.getTotalNum(), "查询成功");
	}
	
	
	@RequestMapping("/checkBrandname")
	@ResponseBody
	public String checkBrandname(String param) {
		return brandService.checkBrandname(param);
	}
	
	@RequestMapping("/tooAddBrand")
	@ResponseBody
	public Map<?, ?>  tooAddBrand() {
		Map<?, ?> map = DataUtil.map.get(Constant.INDUSTRYMAPNAME);
		return map;
	}
	
	@RequestMapping("/addBrand")
	@ResponseBody
	public String addBrand(Brand brand,HttpSession session) {
		User user = (User)session.getAttribute(MyofficeConstants.CURRUSER_SESSION);
		brand.setCreateuser(user.getUserid());
		brandService.addBrand(brand);
		return "增加成功";
	}
	
	@RequestMapping("/toUpdateBrand")
	public String toUpdateBrand() {
		return "institution/brandUpdate";
	}
	
	@RequestMapping("/updateBrand")
	public String updateBrand(Brand brand) {
		brandService.updateBrand(brand);
		return "redirect:pageFindBrand";
	}
	
	@RequestMapping("/deleteBrand")
	@ResponseBody
	public String deleteBrand(int brandid) {
		brandService.deleteBrand(brandid);
		return "删除成功";
	}
}
