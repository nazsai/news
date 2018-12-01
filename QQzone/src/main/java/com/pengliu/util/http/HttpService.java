package com.pengliu.util.http;

import java.util.Map;

import org.assertj.core.util.Maps;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

/**
 * Http请求服务类,提供简单的基本请求信息封装
 */
@Service
public class HttpService{
	
	private Map<String,String> cookies = Maps.newConcurrentHashMap();
	
	public String requestGet(String url) throws Exception {
		return requestHttp(url, Method.GET, null, null);
	}
	
	public String requestGet(String url,SetConnection setConnection) throws Exception {
		return requestHttp(url, Method.GET, null, setConnection);
	}
	
	public String requestPost(String url,Map<String,String> data) throws Exception {
		return requestHttp(url, Method.POST, null, null);
	}
	
	public String requestPost(String url,Map<String,String> data,SetConnection setConnection) throws Exception {
		return requestHttp(url, Method.POST, data, setConnection);
	}
	
	public String requestHttp(String url,Method method,Map<String,String> data,SetConnection setConnection) throws Exception {
		return doRequestHttp(url, method, data, setConnection!=null?setConnection:new SetConnection() {
			@Override
			public String before(Connection conn) {
				conn.cookies(cookies);
				return null;
			}

			@Override
			public String after(Response response) {
				cookies.putAll(response.cookies());
				return null;
			}
		});
	}
	
	public String doRequestHttp(String url,Method method,Map<String,String> data,SetConnection setConnection) throws Exception {
		
		Connection conn = Jsoup.connect(url);
		
		setConnection.before(conn);
		
		if(null != data) {
			conn.data(data);
		}
		
		conn.method(method);
		
		conn.ignoreContentType(true);
		
		Response response = conn.execute();
		
		setConnection.after(response);
		
		return response.body();
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}
}
