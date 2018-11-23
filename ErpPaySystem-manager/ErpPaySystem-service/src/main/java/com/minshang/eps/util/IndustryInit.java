package com.minshang.eps.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.entity.Industry;
import com.minshang.eps.service.interfac.IndustryService;

@Service
public class IndustryInit {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IndustryService industryService;
	
	private  Map<String,String> modulemap = new HashMap<>();

	public IndustryInit() {
		// TODO Auto-generated constructor stub
	}
	
	public Map<String,String> init(){
		Log.debug("开始业态模块初始化");
		List<Industry> list = industryService.findList();
		for (Industry industry : list) {
			modulemap.put(industry.getIndustryid().toString(), industry.getIndustryname());
		}
		Log.debug("业态模块初始化结束");
		return modulemap;
	}

}
