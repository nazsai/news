package com.pengliu.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;

import com.pengliu.config.BaseConfig;
import com.pengliu.service.IndexService;
import com.pengliu.util.http.SetConnection;

public class IndexServiceImpl extends BaseConfig implements IndexService {

	@Override
	public void inIndexInfo() throws Exception {
	//	String indexUrl ="https://user.qzone.qq.com/934092154/main";
	//	String indexUrl = "https://user.qzone.qq.com/540891049/infocenter";
		String indexUrl = "https://user.qzone.qq.com/1025970610/infocenter";
		String htmlResult = httpService.requestGet(indexUrl,new SetConnection() {
			@Override
			public String before(Connection conn) {
				conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:18.0) Gecko/20100101 Firefox/18.0");
				conn.cookies(httpService.getCookies());
				return null;
			}

			@Override
			public String after(Response response) {
				httpService.getCookies().putAll(response.cookies());
				return null;
			}
		});
		
		Pattern pattern =Pattern.compile("return \"([A-Za-z0-9]{0,})\"");//匹配的模式
	    Matcher matcher=pattern.matcher(htmlResult);
	    while(matcher.find())
	    {
	    	g_qzonetoken = matcher.group(1);
	    }
	}
	
}
