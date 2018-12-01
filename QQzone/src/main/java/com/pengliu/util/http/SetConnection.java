package com.pengliu.util.http;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;

/**
 * <p>提供在请求前后，设置请求参数的接口/p>
 * @category  类名
 * @version   1.0     (2013-2-15 下午1:48:46)
 * @since     1.0
 */
public interface SetConnection{
	/** 请求前的处理请求方法 */
	public String before(Connection conn);
	/** 请求后的请求处理方法 */
	public String after(Response response);
}