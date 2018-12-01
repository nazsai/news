package com.pengliu.main;
import com.alibaba.fastjson.JSON;
import com.pengliu.config.BaseConfig;

public class Main extends BaseConfig{
	
	public static void main(String[] args) throws Exception {
		QQ qq = new QQ("568723346", "");
		//登陆QQ
		boolean isLogin = qq.loginQQ();
		
		System.out.println("是否登陆成功:"+(isLogin?"是":"否"));
		System.out.println("登陆后的cookie值===》\t"+JSON.toJSONString(httpService.getCookies()));
		
		//进入首页获取QQ空间Token值
		qq.indexService();
		qq.getShuoShuo("要获取的QQ空间说说的QQ账号");
	}
}
