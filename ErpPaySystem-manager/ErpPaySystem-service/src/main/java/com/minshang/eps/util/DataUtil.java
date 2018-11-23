package com.minshang.eps.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minshang.eps.entity.Module;

public class DataUtil {
	
	public static Logger Log = LoggerFactory.getLogger(DataUtil.class);
	
	public static ConcurrentHashMap<String,Map<?,?>> map = new ConcurrentHashMap<>();
	
	@Resource
	private ModuleInit moduleInit;
	
	@Resource
	private IndustryInit industryInit;
	
	@Resource
	private DishestypeInit dishestypeInit;
	
	public DataUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 系统启动初始化方法
	 */
	public void init(){
		Log.debug("开始数据初始化");
		Map<String, List<Module>> modulemap = moduleInit.init();
		Map<String, String> industrymap = industryInit.init();
		Map<String, String> dishestypemap = dishestypeInit.init();
		map.put(Constant.MODULEMAPNAME, modulemap);
		map.put(Constant.INDUSTRYMAPNAME, industrymap);
		map.put(Constant.DISHESTYPENAME, dishestypemap);
		Log.debug("数据初始化结束");
	}
	
	/**
	 * 数据刷新方法
	 * @param key
	 */
	public void refresh(String key) throws Exception{
		map.remove(key);
		if(Constant.MODULEMAPNAME.equals(key)){
			Map<String, List<Module>> modulemap = moduleInit.init();
			map.put(Constant.MODULEMAPNAME, modulemap);
			return;
		}else if(Constant.INDUSTRYMAPNAME.equals(key)) {
			Map<String, String> industrymap = industryInit.init();
			map.put(Constant.INDUSTRYMAPNAME, industrymap);
			return;
		}else if(Constant.DISHESTYPENAME.equals(key)) {
			Map<String, String> dishestypemap = dishestypeInit.init();
			map.put(Constant.DISHESTYPENAME, dishestypemap);
			return;
		}
	}
}
