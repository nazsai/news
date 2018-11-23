package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.User;

public interface UserMapper {
	
	
	/**
	 * 登录
	 * @param usercode	用户名
	 * @param password	密码
	 * @return
	 */
	User findByUsercodeAndPwd(@Param("usercode" )String usercode, @Param("password") String password);
	
	
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    	
    List<String> findRoles(Integer userid);
}