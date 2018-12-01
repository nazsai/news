package com.minshang.eps.service.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.ShopmoudleMapper;
import com.minshang.eps.entity.Shopmoudle;
import com.minshang.eps.service.interfac.ShopmoudleService;
import com.minshang.eps.util.PageResult;

@Service
public class ShopmoudleServiceImpl implements ShopmoudleService {

	@Autowired
	private ShopmoudleMapper shopmoudleMapper;
	
//	@Override
//	public ReturnValueDomain<PageResult<Shopmoudle>> pageFind(PageParam<?> pageParam) {
//		ReturnValueDomain<PageResult<Shopmoudle>> ret  = new ReturnValueDomain<>();
//		int count = shopmoudleMapper.pageFindCount();
//		List<Shopmoudle> list = null;
//		try {
//			list = shopmoudleMapper.pageFind(pageParam);
//		} catch (Exception e) {
//			return ret.setFail("分页查询模块失败");
//		}
//		PageResult<Shopmoudle> page = new PageResult<Shopmoudle>(pageParam.getCurrPage(),pageParam.getPageSize(),count,list);
//		return ret.setSuccess("分页查询权限模块成功",page);
//	}

	@Override
	public PageResult<Shopmoudle> pageFind(int currPage, int pageSize, Shopmoudle shopmoudle) {
		List<Shopmoudle> list = this.shopmoudleMapper.pageFind(currPage, pageSize, shopmoudle);
		int totalNum = this.shopmoudleMapper.pageFindCount(shopmoudle);
		return new PageResult<Shopmoudle>(currPage, pageSize, totalNum, list);
	}

}
