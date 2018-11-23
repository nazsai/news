package com.minshang.eps.service.size;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minshang.eps.dao.SizeMapper;
import com.minshang.eps.dao.SizerightMapper;
import com.minshang.eps.entity.Size;
import com.minshang.eps.util.NonUtil;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

@Service("sizeService")
@Transactional
public class SizeServiceImpl implements SizeService {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private SizeMapper sizeMapper;
	
	@Resource
	private SizerightMapper sizerightMapper;

	@Override
	public ReturnValueDomain<String> insert(Size size) {
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(NonUtil.isNon(size)) {
			return ret.setFail("参数不能为空");
		}
		if(NonUtil.isNon(size.getSizename())) {
			return ret.setFail("规格名不能为空");
		}
		int row = 0;
		try {
			sizeMapper.insert(size);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		return row > 0 ? ret.setSuccess("新增规格成功") : ret.setFail("新增规格失败");
	}

	@Override
	public ReturnValueDomain<String> delete(Integer sizeid) {
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(NonUtil.isNon(sizeid)) {
			return ret.setFail("参数不能为空");
		}
		try {
			sizerightMapper.deleteBySizeid(sizeid);
			sizeMapper.deleteByPrimaryKey(sizeid);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		return ret.setSuccess("删除规格成功");
	}

	@Override
	public ReturnValueDomain<String> updateByPrimaryKey(Size size) {
		ReturnValueDomain<String> ret = new ReturnValueDomain<>();
		if(NonUtil.isNon(size)) {
			return ret.setFail("参数不能为空");
		}
		if(NonUtil.isNon(size.getSizeid()) || NonUtil.isNon(size.getSizename())) {
			return ret.setFail("id,规格名不能为空");
		}
		int row = 0;
		try {
			row = sizeMapper.updateByPrimaryKey(size);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		return row >0 ? ret.setSuccess("更新规格成功") : ret.setFail("更新规格失败");
	}

	@Override
	public ReturnValueDomain<PageResult<Size>> selectByPage(PageParam<Size> pageParam) {
		ReturnValueDomain<PageResult<Size>> ret = new ReturnValueDomain<>();
		int count = 0;
		List<Size> list = null;
		try {
			count = sizeMapper.count(pageParam.getObject().getSizename());
			list = sizeMapper.selectByPage(pageParam);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		PageResult<Size> page = new PageResult<Size>();
		page.setList(list);
		page.setTotalNum(count);
		return ret.setSuccess("分页查询规格成功", page);
	}


}
