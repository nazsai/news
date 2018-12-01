package com.minshang.eps.service.section;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.SectionMapper;
import com.minshang.eps.service.interfac.SectionService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.SectionVo;
@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionMapper sectionMapper;

	@Override
	public PageResult<SectionVo> pageFind(int currPage, int pageSize,
			SectionVo vo) {
		/** 查询结果集 */
		List<SectionVo> list = sectionMapper.pageFind(currPage, pageSize, vo);
		/** 查询总行数 */
		int totalNum = sectionMapper.pageFindCount(vo);

		return new PageResult<SectionVo>(currPage, pageSize, totalNum, list);
	}

	@Override
	public void addSectionVo(SectionVo vo) {
		sectionMapper.addSectionVo(vo);

	}

	@Override
	public String checkSectionname(String sectionname) {
		int count = sectionMapper.getCountBySectionname(sectionname);
		if (count > 0) {
			return "该部门已存在！";
		} else {
			return "可以添加";
		}

	}

	@Override
	public void deleteById(int sectionid) {
		final String state = "1";
		sectionMapper.updateStateById(sectionid, state);
	}

	@Override
	public void updateSectionVo(SectionVo vo) {
		sectionMapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public SectionVo findById(int id) {

		return sectionMapper.selectByPrimaryKey(id);
	}

}
