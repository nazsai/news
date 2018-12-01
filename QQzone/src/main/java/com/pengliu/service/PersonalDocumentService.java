package com.pengliu.service;

/**
 * 获取个人信息
 * @author Administrator
 *
 */
public interface PersonalDocumentService {
	/**
	 * desc: 获取个人文档信息
	 * @throws Exception 
	 */
	void getUserInfo() throws Exception;
	
	/**
	 * desc: 修改个人信息
	 */
	void updateUserInfo() throws Exception;
}
