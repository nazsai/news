package com.minshang.eps.service.selmeal;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minshang.eps.dao.SelmealMapper;
import com.minshang.eps.entity.Selmeal;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

@Service("selmealService")
@Transactional
public class SelmealServiceImpl implements SelmealService {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private SelmealMapper selmealMapper;

	@Override
	public ReturnValueDomain<PageResult<Selmeal>> selectByPage(PageParam<Selmeal> pageParam) {
		ReturnValueDomain<PageResult<Selmeal>> ret = new ReturnValueDomain<>();
		int count = 0;
		List<Selmeal> list = null;
		try {
			count = selmealMapper.count(pageParam);
			list = selmealMapper.selectByPage(pageParam);
		} catch (Exception e) {
			Log.error("服务器错误",e);
			return ret.setFail("服务器错误");
		}
		PageResult<Selmeal> page = new PageResult<>();
		page.setList(list);
		page.setTotalNum(count);
		return ret.setSuccess("查询套餐成功", page);
	}

}
