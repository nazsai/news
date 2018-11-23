package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.Section;
import com.minshang.eps.vo.SectionVo;

public interface SectionMapper {
	/**
	 * 分页查询结果集
	 * @param currPage 当前页
	 * @param pageSize 当前行 
	 * @param vo 查询条件
	 * @return
	 */
	List<SectionVo>pageFind(@Param("currPage")int currPage,@Param("pageSize")int pageSize,
			@Param("vo")SectionVo vo);
	/**
	 * 查询总条数
	 * @param vo
	 * @return
	 */
	int pageFindCount(@Param("vo")SectionVo vo);
	
	/**
	 * 添加一条数据
	 * @param vo
	 */
	public void addSectionVo(SectionVo vo);
	/**
	 * 根据部门名查询数据
	 * @param sectionname
	 * @return
	 */
	int getCountBySectionname(String sectionname);
	/**
	 * 根据组织id修改状态
	 * @param sectionid
	 * @param state
	 */
	void updateStateById(@Param("sectionid")int sectionid,@Param("state")String state);
	
    int deleteByPrimaryKey(Integer sectionid);

    int insert(Section record);

    int insertSelective(Section record);

    SectionVo selectByPrimaryKey(Integer sectionid);

    int updateByPrimaryKeySelective(SectionVo record);

    int updateByPrimaryKey(Section record);
}