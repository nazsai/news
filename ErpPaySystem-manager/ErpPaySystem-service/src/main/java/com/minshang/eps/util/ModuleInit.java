package com.minshang.eps.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.minshang.eps.entity.Module;
import com.minshang.eps.service.module.ModuleService;

@Service
public class ModuleInit{
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ModuleService moduleService;
	
	private  Map<String,List<Module>> modulemap = new HashMap<>();
	
	public ModuleInit() {
		// TODO Auto-generated constructor stub
	}
	
	public Map<String,List<Module>> init(){
		Log.debug("开始模块初始化");
		List<Module> list = moduleService.selectAllModules();
		List<Module> listto = null;
		for (Module module : list) {
			if(!modulemap.containsKey(module.getRolename())){
				listto = new ArrayList<>();
				listto.add(module);
				modulemap.put(module.getRolename(), listto);
				continue;
			}
			listto = modulemap.get(module.getRolename());
			listto.add(module);
		}
		Log.debug("模块初始化结束，模块{}",modulemap.toString());
		return modulemap;
	}

}
