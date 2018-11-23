package com.minshang.eps.service.interfac;

import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.SectionVo;


public interface SectionService {
	/**
	 * 分页查询
	 * @param currPage
	 * @param pageSize
	 * @param vo
	 * @return
	 */
	PageResult<SectionVo>pageFind(int currPage, int pageSize,SectionVo vo);
	/**
	 * 添加一条数据 
	 * @param vo
	 */
	void addSectionVo(SectionVo vo);
	/**
	 * 判断部门名是否重复
	 * @param Sectionname
	 * @return
	 */
	String checkSectionname(String sectionname);
	/**
	 * 删除
	 * @param sectionid
	 * @return 
	 */
	int deleteById(int sectionid);
	/**
	 * 修改
	 * @param vo
	 */
	void updateSectionVo(SectionVo vo);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	SectionVo findById(int id);
}

