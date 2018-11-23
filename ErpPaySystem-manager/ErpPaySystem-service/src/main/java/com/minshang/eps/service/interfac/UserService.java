package com.minshang.eps.service.interfac;

import java.util.List;

import com.minshang.eps.entity.User;


/**
 * 用户登录业务层接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 登录
	 * @param usercode 用户名
	 * @param password 密码
	 * @return
	 */
	User login(String usercode , String password);
	
	List<String> findRoles(Integer userid);
	
}
