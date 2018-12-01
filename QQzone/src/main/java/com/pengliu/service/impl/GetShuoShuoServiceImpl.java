package com.pengliu.service.impl;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;

import com.pengliu.config.BaseConfig;
import com.pengliu.service.GetShuoShuoService;
import com.pengliu.util.http.SetConnection;

public class GetShuoShuoServiceImpl extends BaseConfig implements GetShuoShuoService{

	@Override
	public void getShuoShuo(String QQNum) throws Exception {
		// TODO Auto-generated method stub
		String shuoshuourl=		"https://h5.qzone.qq.com/proxy/domain/"
		+ "taotao.qq.com/cgi-bin/emotion_cgi_msglist_v6?"
		+ "uin="+QQNum+"&"
		+ "ftype=0&sort=0&"
		+ "pos=20&num=20&"
		+ "replynum=100&"
		+ "g_tk="+BaseConfig.g_tk+"&"
		+ "callback=_preloadCallback&"
		+ "code_version=1&"
		+ "format=jsonp&"
		+ "need_private_comment=1&"
		+ "qzonetoken="+BaseConfig.g_qzonetoken;
		String htmlResult = httpService.requestGet(shuoshuourl,new SetConnection() {
			@Override
			public String before(Connection conn) {
				conn.header("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36 UCBrowser/11.7.5.955");
				conn.header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
				conn.cookies(httpService.getCookies());
				return null;
			}
			
			@Override
			public String after(Response response) {
				httpService.getCookies().putAll(response.cookies());
				return null;
			}
		});
		System.out.println(htmlResult);
	}

}
