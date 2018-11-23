package com.minshang.eps.dishesdepot;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Dishesdepot;
import com.minshang.eps.entity.User;
import com.minshang.eps.service.dishesdepot.DishesdepotService;
import com.minshang.eps.util.MyofficeConstants;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.PageUtil;
import com.minshang.eps.util.ReturnValueDomain;

@Controller
@RequestMapping("/dishesdepot")
public class DishesdepotController {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DishesdepotService dishesdepotService;

	@RequestMapping("/list")
	@ResponseBody
	public Object selectByPage(@ModelAttribute PageParam<Dishesdepot> pageParam ,@ModelAttribute Dishesdepot dishesdepot) {
		Log.debug("页码{}，每页显示{}",pageParam.getCurrPage(),pageParam.getPageSize());
		pageParam.setObject(dishesdepot);
		ReturnValueDomain<PageResult<Dishesdepot>> ret = dishesdepotService.selectByPage(pageParam);
		PageResult<Dishesdepot> page = ret.getObject();				
		return PageUtil.parseData(page.getList(), page.getTotalNum(),ret.getResultdesc());
	}
	
	@RequestMapping("/changestate")
	@ResponseBody
	public Object changestate(@ModelAttribute Dishesdepot dishesdepot) {
		return dishesdepotService.changestate(dishesdepot);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(@ModelAttribute Dishesdepot dishesdepot , HttpSession session) {
		User user = (User)session.getAttribute(MyofficeConstants.CURRUSER_SESSION);
		Log.debug(user.getUserid().toString());
		dishesdepot.setCreateuser(user.getUserid());
		return dishesdepotService.insert(dishesdepot);
	}
}
