package com.minshang.eps.institution;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.User;
import com.minshang.eps.service.interfac.AreaService;
import com.minshang.eps.util.Constant;
import com.minshang.eps.util.DataUtil;
import com.minshang.eps.util.MyofficeConstants;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.vo.AreaVo;
import com.minshang.eps.vo.BrandVo;

/**
 * 区域控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/institution")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/pageFindArea")
	@ResponseBody
	public Object pageFind(
			@RequestParam(defaultValue = "1", required = false) Integer currPage,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			AreaVo areaVo
			){
		PageResult<AreaVo> page = areaService.pageFind(currPage, pageSize, areaVo);
		return PageUtil.parseData(page.getList(), page.getTotalNum(), "查询成功");
	}
	
	@RequestMapping("/toAddAreaPage")
	@ResponseBody
	public Map<?, ?> toAddAreaPage() {
		Map<?, ?> map = DataUtil.map.get(Constant.BRANDNAME);
		return map;
	}
	
	@RequestMapping("/addArea")
	@ResponseBody
	public String addArea(AreaVo areaVo,HttpSession session) {
		User user = (User)session.getAttribute(MyofficeConstants.CURRUSER_SESSION);
		areaVo.setUsername(user.getUsername());
		areaService.addArea(areaVo);
		return "增加成功";
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
