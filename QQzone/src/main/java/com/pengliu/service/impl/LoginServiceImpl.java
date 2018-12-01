package com.pengliu.service.impl;

import java.io.File;

import com.alibaba.fastjson.JSON;
import com.pengliu.config.BaseConfig;
import com.pengliu.service.LoginService;
import com.pengliu.util.QQUtil;
import com.pengliu.util.Security;

public class LoginServiceImpl extends BaseConfig implements LoginService{

	@Override
	public void init() throws Exception {
		String url = "http://ui.ptlogin2.qq.com/cgi-bin/login?style=9&pt_ttype=1&appid=549000929&pt_no_auth=1&pt_wxtest=1&daid=5&s_url=https%3A%2F%2Fh5.qzone.qq.com%2Fmqzone%2Findex";
		httpService.requestGet(url);
	}

	@Override
	public boolean checkQQ() throws Exception {
		//检查账号是否需要验证码验证
		String url = "http://check.ptlogin2.qq.com/check?pt_tea=2&uin="+qqNum+"&appid=549000929&ptlang=2052&regmaster=&pt_uistyle=9&r=0.7218746354337782&pt_jstoken=3818166328";
		String ValiDateString = httpService.requestGet(url);
		
		String [] checkVCs = QQUtil.analytical_QQ_Return("ptui_checkVC",ValiDateString);
		
		//是否通过验证码
		boolean isTF = false;
		
		if("0".equals(checkVCs[0])){
			vCode = checkVCs[0];
			verifycode=checkVCs[1];
			hexQQ = checkVCs[2];
			verifysession = checkVCs[3];
			isTF = true;
		}else {
			System.out.println("需要手工验证");
		}
		
		return isTF;
	}

	@Override
	public boolean loginQQ() throws Exception {
		//转换16进制字符
		hexQQ = Security.hexchar2bin(hexQQ.substring(2).replace("\\x", "").toUpperCase());
		System.out.println("hexQQ:"+hexQQ);
		//File javaScriptFile = new File(javaProjectPath+"/js/login.js");
		File javaScriptFile = new File(this.getClass().getResource("/js/login.js").getPath());
		System.out.println(javaScriptFile);
		loginP = (String)QQUtil.exeJavascript(javaScriptFile,"getQQEncryption",qqPwd,hexQQ,verifycode,false);
		loginP = loginP.replaceAll("/", "-").replaceAll("\\+", "*").replaceAll("=", "_");
		
		String url = "https://ptlogin2.qq.com/login?pt_vcode_v1="+vCode+"&pt_verifysession_v1="+verifysession+"&verifycode="+verifycode+"&u="+qqNum+"&p="+loginP+"&pt_randsalt=2&ptlang=2052&low_login_enable=0&u1=https%3A%2F%2Fh5.qzone.qq.com%2Fmqzone%2Findex&from_ui=1&fp=loginerroralert&device=2&aid=549000929&daid=5&pt_ttype=1&pt_3rd_aid=0&ptredirect=1&h=1&g=1&pt_uistyle=9&regmaster=&";
		String loginStr = httpService.requestGet(url);
		
		String [] loginArry = QQUtil.analytical_QQ_Return("ptuiCB", loginStr);
		
		System.out.println(JSON.toJSONString(loginArry));
		
		boolean isLogin = true;
		if("登录成功！".equals(loginArry[4])) {
			checkSigUrl = loginArry[2];
		}else {
			isLogin = false;
		}
		return isLogin;
	}

	@Override
	public boolean CheckSig() throws Exception {
		boolean isTF = false;
		
		httpService.requestGet(checkSigUrl);
		
		if(httpService.getCookies().containsKey("p_skey")) {
			g_tk = Security.GetG_TK(httpService.getCookies().get("p_skey"));
			httpService.getCookies().put("g_tk", g_tk);
			isTF = true;
		}
		
		return isTF;
	}
	
	

}
