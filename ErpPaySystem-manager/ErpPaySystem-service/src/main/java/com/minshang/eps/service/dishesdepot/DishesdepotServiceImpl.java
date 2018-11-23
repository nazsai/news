package com.minshang.eps.service.dishesdepot;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minshang.eps.dao.DishesdepotMapper;
import com.minshang.eps.entity.Dishesdepot;
import com.minshang.eps.util.NonUtil;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

@Service(value="dishesdepotService")
@Transactional
public class DishesdepotServiceImpl implements DishesdepotService{
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private DishesdepotMapper dishesdepotMapper;

	@Override
	public ReturnValueDomain<String> insert(Dishesdepot dishesdepot) {
		// TODO Auto-generated method stub
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(NonUtil.isNon(dishesdepot)) {
			return ret.setFail("参数不能为空");
		}
		if(NonUtil.isNon(dishesdepot.getDishesdepotname())) {
			return ret.setFail("菜品库名不能为空");
		}
		int row = 0;
		try {
			row = dishesdepotMapper.checkrepeat(dishesdepot.getDishesdepotname());
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		if(row > 0) {
			return ret.setFail("菜品名不能重复!");
		}
		try {
			row = dishesdepotMapper.insert(dishesdepot);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		return row > 0 ? ret.setSuccess("新增菜品库成功") : ret.setFail("新增菜品库失败");
	}

	@Override
	public ReturnValueDomain<String> changestate(Dishesdepot dishesdepot) {
		// TODO Auto-generated method stub
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(NonUtil.isNon(dishesdepot)) {
			return ret.setFail("参数不能为空");
		}
		if(NonUtil.isNon(dishesdepot.getDishesdepotid()) || NonUtil.isNon(dishesdepot.getState())) {
			return ret.setFail("参数不能为空");
		}
		try {
			dishesdepotMapper.changestate(dishesdepot);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		return ret.setSuccess("变更菜品库状态成功");
	}

	@Override
	public ReturnValueDomain<PageResult<Dishesdepot>> selectByPage(PageParam<?> pageParam) {
		ReturnValueDomain<PageResult<Dishesdepot>> ret = new ReturnValueDomain<>();
		int count = dishesdepotMapper.count();
		List<Dishesdepot> list = null;
		try {
			list = dishesdepotMapper.selectByPage(pageParam);
		} catch (Exception e) {
			Log.error("分页查询菜品失败",e);
			return ret.setFail("分页查询菜品失败");
		}
		PageResult<Dishesdepot> page= new PageResult<>(pageParam.getCurrPage(),pageParam.getPageSize(),count,list);		
		return ret.setSuccess("分页查询菜品库成功", page);
	}


}
