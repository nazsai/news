package com.minshang.eps.service.interfac;

import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.AreaVo;

/**
 * 区域业务层接口
 * @author Administrator
 *
 */
public interface AreaService {

	PageResult<AreaVo> pageFind(int currPage, int pageSize , AreaVo areaVo);
	
	void addArea(AreaVo areaVo);
	
	String checkByName(String brandname , String areaname);
	
	AreaVo findByAreaid(int areaid);
	
	void updateArea(AreaVo areaVo);
	
	void deleteArea(int areaid);
}
