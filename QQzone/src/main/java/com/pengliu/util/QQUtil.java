package com.pengliu.util;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;

public class QQUtil {
	/**
	 * 解析验证登录时的返回信息，并封装到字符串数组里面
	 * @param headStr 方法头ptui_checkVC
	 * @param str 需要解析的字符串       格式：ptui_checkVC('1','Sy9B6JOzRSCxoHQL9AJCwNLVxTRiS6Jk1GK3W8W-I63XrzpfBUjhMA**','\x00\x00\x00\x00\x45\xd6\xd5\x03','','0');
	 * @return
	 */
	public static String[] analytical_QQ_Return(String headStr , String str){
		str = str.replace(headStr+"(", "");
		str = str.replace(")", "");
		str = str.replace(";", "");
		String [] strings = str.split(",");
		for(int i=0;i<strings.length;i++){
			strings[i]=strings[i].replaceAll("'","");
		}
		return strings;
	}
	
	/**
	 * java调用javascript代码
	 * @param file	js文件对象
	 * @param functionName	需要调用的方法名称
	 * @param params 此方法需要传入的参数
	 * @return 返回得到的结果
	 * @throws Exception 
	 */
	public static Object exeJavascript(File file , String functionName , Object... parms) throws Exception{
		ScriptEngineManager manager = new ScriptEngineManager();   
		ScriptEngine engine = manager.getEngineByName("js");     
		FileReader reader = new FileReader(file);   // 执行指定脚本   
		engine.eval(reader);
		if(engine instanceof Invocable) {
			Invocable invoke = (Invocable)engine;
			Object object = invoke.invokeFunction(functionName,parms); 
			return object;
		}
		return null;
	}
	
	public static Map<String,String> cookieString2map(String cookies){
		cookies = cookies.replaceAll(" ", "");
		List<String> list = Lists.newArrayList(cookies.split(";"));
		Map<String,String> cookieMap = Maps.newConcurrentHashMap();
		for (String string : list) {
			if(!string.isEmpty() && string.contains("=")) {
				String key = string.substring(0, string.indexOf("="));
				String value = string.substring(string.indexOf("=")+1);
				cookieMap.put(key, value);
			}
		}
		return cookieMap;
	}
	
	
	public static String cookieMap2String(Map<String,String> cookieMap) {
		String cookieStr = "";
		for(Map.Entry<String, String> map:cookieMap.entrySet()) {
			cookieStr+=map.getKey()+"="+map.getValue()+";";
		}
		return cookieStr;
	}
}
