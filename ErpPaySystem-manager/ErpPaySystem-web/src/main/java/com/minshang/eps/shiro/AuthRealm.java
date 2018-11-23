package com.minshang.eps.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.minshang.eps.entity.User;
import com.minshang.eps.service.interfac.UserService;

public class AuthRealm extends AuthorizingRealm {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		Log.debug("授权");
		//获取当前登录人对象
		//User user = (User) pc.fromRealm(this.getName()).iterator().next();
		//该用户拥有的所有权限（模块）标示
		//Set<String> permissions = new HashSet<String>();
		//该用户拥有的所有权限（角色）标示
		//List<String> roleList = userService.findRoles(user.getUsercode());
		//log.debug(roleList.toString());
		
		//根据具体业务逻辑，进行授权---------------
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//info.addStringPermissions(permissions);
		//info.addRoles(roleList);
		return info;
	}

	//认证
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		Log.debug("认证");
		//向下转型	代表用户在页面输入的用户名和密码
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//用户名
		String usercode = upToken.getUsername();
		//密码
		String password = new String(upToken.getPassword());
		
		//真正的认证  -->你可以改动的东西
		User user = userService.login(usercode, password);
		
		if (user != null) {
			/*
			 * 如果需要单独进入密码比较器，则第二个参数为user.getPassword()
			 * 如果不进入密码比较器，
			 * 则第二个参数必须为用户输入的密码
			 */
			AuthenticationInfo info = new SimpleAuthenticationInfo(user, password, this.getName());
			return info;	//...此处如果返回立即进入密码比较器
		}
		return null;
	}
	
}
