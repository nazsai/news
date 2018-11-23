package com.minshang.eps.service.institution;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.IndustryMapper;
import com.minshang.eps.entity.Industry;
import com.minshang.eps.service.interfac.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryMapper industryMapper;

	@Override
	public List<Industry> findList() {
		return industryMapper.findList();
	}
	
	
	
}
