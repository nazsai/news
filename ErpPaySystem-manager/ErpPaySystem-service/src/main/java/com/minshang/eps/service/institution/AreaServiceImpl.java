package com.minshang.eps.service.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.AreaMapper;
import com.minshang.eps.service.interfac.AreaService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.AreaVo;

/**
 * 区域表业务层
 * @author Administrator
 *
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public PageResult<AreaVo> pageFind(int currPage, int pageSize, AreaVo areaVo) {
		// 分页查询结果集
		List<AreaVo> list = areaMapper.pageFind(currPage, pageSize, areaVo);
		// 分页查询总条数
		int totalNum = areaMapper.pageFindCount(areaVo);
		return new PageResult<AreaVo>(currPage, pageSize, totalNum, list);
	}

	@Override
	public void addArea(AreaVo areaVo) {
		areaMapper.addArea(areaVo);
	}

	@Override
	public String checkByName(String brandname, String areaname) {
		int count = this.areaMapper.getCountByName(brandname, areaname);
		if (count > 0) {
			return "该品牌及区域已存在！！";
		}
		return "y";
	}

	@Override
	public AreaVo findByAreaid(int areaid) {
		return this.findByAreaid(Integer.valueOf(areaid));
	}

	@Override
	public void updateArea(AreaVo areaVo) {
		this.areaMapper.updateByPrimaryKeySelective(areaVo);
	}

	@Override
	public void deleteArea(int areaid) {
		this.areaMapper.deleteByPrimaryKey(areaid);		
	}

}
