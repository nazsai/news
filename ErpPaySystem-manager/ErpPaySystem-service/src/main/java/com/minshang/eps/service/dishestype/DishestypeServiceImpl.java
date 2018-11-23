package com.minshang.eps.service.dishestype;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minshang.eps.dao.DishestypeMapper;
import com.minshang.eps.entity.Dishestype;
import com.minshang.eps.util.ReturnValueDomain;

@Service("dishestypeService")
@Transactional
public class DishestypeServiceImpl implements DishestypeService {

	@Resource
	private DishestypeMapper dishestypeMapper;
	
	@Override
	public ReturnValueDomain<String> insert(Dishestype record) {
		// TODO Auto-generated method stub
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(null == record){
			return ret.setFail("参数不能为空");
		}
		if(null == record.getDishestypename()){
			return ret.setFail("菜品种类名称不能为空");
		}
		return dishestypeMapper.insert(record) > 0 ? ret.setSuccess("新增菜品种类成功"):ret.setFail("新增菜品种类失败");
	}

	@Override
	public ReturnValueDomain<String> deleteByPrimaryKey(Integer dishestypeid) {
		// TODO Auto-generated method stub
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(null == dishestypeid){
			return ret.setFail("参数不能为空");
		}	
		return dishestypeMapper.deleteByPrimaryKey(dishestypeid) > 0 ? ret.setSuccess("删除菜品种类成功"):ret.setFail("删除菜品种类失败");
	}

	@Override
	public ReturnValueDomain<String> updateByPrimaryKey(Dishestype record) {
		// TODO Auto-generated method stub
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(null == record){
			return ret.setFail("参数不能为空");
		}
		if(null == record.getDishestypeid()){
			return ret.setFail("菜品id不能为空");
		}
		if(null == record.getDishestypename()){
			return ret.setFail("菜品种类名称不能为空");
		}
		return dishestypeMapper.updateByPrimaryKey(record) > 0 ? ret.setSuccess("修改菜品种类成功"):ret.setFail("修改菜品种类失败");
	}

	@Override
	public ReturnValueDomain<List<Dishestype>> select(Dishestype record) {
		// TODO Auto-generated method stub
		ReturnValueDomain<List<Dishestype>> ret = new ReturnValueDomain<>();
		List<Dishestype> list = dishestypeMapper.select(record);
		return ret.setSuccess("菜品种类查询成功", list);
	}

}
