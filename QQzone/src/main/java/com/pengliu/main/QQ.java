package com.pengliu.main;

import com.pengliu.config.BaseConfig;
import com.pengliu.service.GetShuoShuoService;
import com.pengliu.service.IndexService;
import com.pengliu.service.LoginService;
import com.pengliu.service.PersonalDocumentService;
import com.pengliu.service.impl.GetShuoShuoServiceImpl;
import com.pengliu.service.impl.IndexServiceImpl;
import com.pengliu.service.impl.LoginServiceImpl;
import com.pengliu.service.impl.PersonalDocumentServiceImpl;

public class QQ extends BaseConfig{
	//登陆业务
	private LoginService loginService = new LoginServiceImpl();
	//个人文档业务
	private PersonalDocumentService personalDocumentService = new PersonalDocumentServiceImpl();
	//首页业务
	private IndexService indexService = new IndexServiceImpl();
	//获取说说数据
	private GetShuoShuoService getShuoShuoService = new GetShuoShuoServiceImpl();
	
	/**
	 * QQ业务 构造函数
	 * @param qqNum QQ账号
	 * @param qqPwd	QQ密码
	 */
	public QQ(String qqNum,String qqPwd) {
		BaseConfig.qqNum = qqNum;
		BaseConfig.qqPwd = qqPwd;
	}
	/**
	 * desc: 登陆QQ
	 * @throws Exception 
	 */
	public boolean loginQQ() throws Exception {
		//初始化登陆链接
		loginService.init();
		//检查QQ状态
		boolean isTF = loginService.checkQQ();
		if(isTF) {
			//登陆QQ
			isTF = loginService.loginQQ();
		}
		if(isTF) {
			//访问认证
			isTF = loginService.CheckSig();
		}
		return isTF;
	}
	
	public void indexService() throws Exception {
		indexService.inIndexInfo();
	}
	
	public void userInfo() throws Exception{
		//查看个人信息业务
		personalDocumentService.getUserInfo();
		//修改个人信息业务
		personalDocumentService.updateUserInfo();
	}
	public void getShuoShuo(String qq) throws Exception{
		getShuoShuoService.getShuoShuo(qq);
	}
}
