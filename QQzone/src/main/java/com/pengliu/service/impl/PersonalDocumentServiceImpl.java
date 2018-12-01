package com.pengliu.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import org.assertj.core.util.Maps;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;

import com.pengliu.config.BaseConfig;
import com.pengliu.service.PersonalDocumentService;
import com.pengliu.util.DateUtil;
import com.pengliu.util.http.SetConnection;

public class PersonalDocumentServiceImpl extends BaseConfig implements PersonalDocumentService{

	@Override
	public void getUserInfo() throws Exception {
		String indexUrl = "https://h5.qzone.qq.com/proxy/domain/base.qzone.qq.com/cgi-bin/user/cgi_userinfo_get_all?uin="+qqNum+"&vuin="+qqNum+"&fupdate=1&rd=0.41901835426688194&g_tk="+g_tk+"&qzonetoken="+g_qzonetoken;
		String htmlResult = httpService.requestGet(indexUrl,new SetConnection() {
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

	@Override
	public void updateUserInfo() throws Exception {
		Calendar c = new GregorianCalendar();
		c.add(Calendar.YEAR, -1);
        String birthday = DateUtil.formatDate(c.getTime(), "yyyy-MM-dd");
		
		String indexUrl = "https://h5.qzone.qq.com/proxy/domain/w.qzone.qq.com/cgi-bin/user/cgi_apply_updateuserinfo_new?qzonetoken="+g_qzonetoken+"&g_tk="+g_tk;
		Map<String,String> data = Maps.newConcurrentHashMap();
		data.put("nickname", "冰封雪恋");
		data.put("emoji", "");
		data.put("sex", "1");
		data.put("birthday", birthday);
		data.put("province", "50");
		data.put("city", "21");
		data.put("country", "1");
		data.put("marriage", "0");
		data.put("bloodtype", "3");
		data.put("hp", "50");
		data.put("hc", "21");
		data.put("hco", "1");
		data.put("career", "");
		data.put("company", "重庆拓诊信息技术有限公司");
		data.put("cp", "0");
		data.put("cc", "0");
		data.put("cb", "");
		data.put("cco", "0");
		data.put("lover", "");
		data.put("islunar", "0");
		data.put("mb", "4");
		data.put("uin", qqNum);
		data.put("pageindex", "1");
		data.put("fupdate", "1");
		data.put("qzreferrer", "https://qzs.qq.com/qzone/v6/setting/profile/profile.html?tab=base");
		String result = httpService.requestPost(indexUrl, data,new SetConnection() {
			@Override
			public String before(Connection conn) {
				conn.header("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36 UCBrowser/11.7.5.955");
				conn.header("Origin", "https://user.qzone.qq.com");
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
		
		System.out.println(result);
	}

}
