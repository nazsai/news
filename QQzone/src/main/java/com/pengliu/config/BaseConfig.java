package com.pengliu.config;

import com.pengliu.util.http.HttpService;

/**
 * desc: 全局公共属性配置
 */
public class BaseConfig {
	//项目路径
	public static String javaProjectPath=System.getProperty("user.dir");
	//QQ账号
	public static String qqNum;
	//QQ密码
	public static String qqPwd;
	//QQ状态:(0:不需要验证码,其他需要验证码)
	public static String vCode;
	//登录QQ的验证码
	public static String verifycode;
	//QQ账号16进制字符
	public static String hexQQ;
	//QQ的验证码session
	public static String verifysession;
	//QQ的安全加密字符
	public static String loginP;
	//检查认证的URL请求地址
	public static String checkSigUrl;
	//QQ空间的g_tk
	public static String g_tk;
	//QQ空间Token值
	public static String g_qzonetoken;
	//地址请求工具
	public static HttpService httpService = new HttpService();
}

