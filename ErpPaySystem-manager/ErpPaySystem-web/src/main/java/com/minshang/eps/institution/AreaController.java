package com.minshang.eps.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minshang.eps.service.interfac.AreaService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.AreaVo;

/**
 * 区域控制层
 * @author Administrator
 *
 */
@Controller
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/pageFindArea")
	public String pageFind(
			@RequestParam(defaultValue = "1", required = false) Integer currPage,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			AreaVo areaVo , Model model
			){
		PageResult<AreaVo> page = areaService.pageFind(currPage, pageSize, areaVo);
		model.addAttribute("page", page);
		model.addAttribute("areaVo", areaVo);
		return "institution/areaList";
	}
	
	@RequestMapping("/toAddAreaPage")
	public String toAddAreaPage() {
		return "institution/areaAdd";
	}
	
	@RequestMapping("/addArea")
	public String addArea(AreaVo areaVo) {
		areaService.addArea(areaVo);
		return "redirect:pageFindArea";
	}
	
	@RequestMapping("/toUpdateAreaPage")
	public String toUpdateAreaPage() {
		return "institution/areaUpdate";
	}
	
	@RequestMapping("/updateArea")
	public String updateArea(AreaVo areaVo) {
		areaService.updateArea(areaVo);
		return "redirect:pageFindArea";
	}
	
}
