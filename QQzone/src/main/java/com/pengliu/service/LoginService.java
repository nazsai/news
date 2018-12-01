package com.pengliu.service;

public interface LoginService {
	/**
	 * 
	 * desc: 初始化获取cookie值
	 * @throws Exception 
	 */
	void init() throws Exception;
	
	/**
	 * desc: 检查QQ状态(检查是否需要验证码)
	 * @throws Exception
	 */
	boolean checkQQ() throws Exception;
	
	/**
	 * desc: 提交登陆QQ
	 * @throws Exception
	 */
	boolean loginQQ() throws Exception;
	
	/**
	 * desc: 检查认证信息
	 * @throws Exception
	 * @return 
	 */
	boolean CheckSig() throws Exception;
}
