package com.minshang.eps.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.UserMapper;
import com.minshang.eps.entity.User;
import com.minshang.eps.service.interfac.UserService;

/**
 * 员工信息业务层
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String usercode, String password) {
		return userMapper.findByUsercodeAndPwd(usercode, password);
	}

	@Override
	public List<String> findRoles(Integer userid) {	
		return userMapper.findRoles(userid);
	}

	
}
