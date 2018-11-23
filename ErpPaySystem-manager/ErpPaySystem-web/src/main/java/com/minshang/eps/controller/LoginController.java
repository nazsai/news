package com.minshang.eps.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minshang.eps.entity.User;
import com.minshang.eps.service.interfac.UserService;
import com.minshang.eps.util.MyofficeConstants;

@Controller
public class LoginController {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login")
	public String dologin(){
		return "login";
	}
	
	@RequestMapping("/dologin")
	public String login(String usercode, String password, HttpSession session, Model model) {
		
		try {
			//1.得到Subject
			Subject subject = SecurityUtils.getSubject();
			
			//2.封装usercode,password
			UsernamePasswordToken token = 
					new UsernamePasswordToken(usercode, password);
			
			//去认证  执行AuthRealm类中doGetAuthenticationInfo方法，如果不通过，会报异常
			subject.login(token);
			
			//3.登录成功时，从shiro中读取用户的登录信息
			User user = (User) subject.getPrincipal();	
			
			//4.把用户信息放入session中
			session.setAttribute(MyofficeConstants.CURRUSER_SESSION, user);
			
		//如果认证不通过返回null,会报异常	
		} catch (AuthenticationException e) {
			model.addAttribute("msg", "用户名或密码错误");
			return "login";
		}
		
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
