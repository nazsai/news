package com.minshang.eps.service.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minshang.eps.dao.ModuleMapper;
import com.minshang.eps.entity.Module;

@Service
@Transactional
public class ModuleService {
	
	@Resource
	private ModuleMapper moduleMapper;
	
	public List<Module> selectAllModules(){
		return moduleMapper.selectAllModules();
	}
	
	
}
