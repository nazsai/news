package com.pengliu.controller;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pengliu.config.BaseConfig;
import com.pengliu.main.QQ;

@Controller
@Scope("prototype")
@RequestMapping("/qq")
public class QQcontroller extends BaseConfig{
	
	@RequestMapping("/loginqq")
	@ResponseBody
	public Object loginqq(String username,String password) {
		QQ qq = new QQ(username,password);
		//登陆QQ
		boolean isLogin = false;
		try {
			isLogin = qq.loginQQ();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("是否登陆成功:"+(isLogin?"是":"否"));
		Map<String, String> map = httpService.getCookies();
		System.out.println("登陆后的cookie值===》\t"+JSON.toJSONString(map));
		
		//进入首页获取QQ空间Token值
		try {
			qq.indexService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			qq.getShuoShuo("要获取的QQ空间说说的QQ账号");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
