package com.minshang.eps.module;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.entity.Module;
import com.minshang.eps.entity.User;
import com.minshang.eps.service.interfac.UserService;
import com.minshang.eps.util.Constant;
import com.minshang.eps.util.DataUtil;
import com.minshang.eps.util.MyofficeConstants;

@Controller
@RequestMapping("/module")
public class ModuleController {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 获得角色模块方法，支持多角色
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findModules")
	@ResponseBody
	public Object findModules(HttpSession session){		
		User user = (User)session.getAttribute(MyofficeConstants.CURRUSER_SESSION);		
		Log.debug("用户名：{}",user.getUsercode());
		List<String> rolelist = userService.findRoles(user.getUserid());
		Map<?, ?> map = DataUtil.map.get(Constant.MODULEMAPNAME);
		List<Module> modulelist = null;
		//Set<Module> moduleset = new HashSet<>();
		Set<Module> moduleset = new TreeSet<>();
		for (String rolename : rolelist) {
			Log.debug("角色名{}",rolename);
			modulelist = (List<Module>) map.get(rolename);
			for (Module module : modulelist) {
				moduleset.add(module);
			}
		}
		Log.debug("模块名{}",moduleset.toString());
		return moduleset;		
	}
}
