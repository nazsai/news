package com.minshang.eps.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.service.interfac.SectionService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.SectionVo;

@Controller
public class SectionController {
	@Autowired
	private SectionService sectionService;

	@RequestMapping("/pageFindSection")
	public String pageFind(
			@RequestParam(defaultValue = "1", required = false) Integer currPage,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			SectionVo vo, Model model) {

		PageResult<SectionVo> page = sectionService.pageFind(currPage,
				pageSize, vo);
		model.addAttribute("page", page);
		model.addAttribute("vo", vo);
		return "branch/TbDiniSectionList";
	}

	@RequestMapping("/toAddSectionVo")
	public String toAddSectionVo() {
		return "branch/TbDiniSectionAdd";
	}

	@RequestMapping("/addSectionVo")
	public String addSectionVo(SectionVo vo) {
		sectionService.addSectionVo(vo);
		return "redirect:pageFindSection";
	}

	@RequestMapping("/checkSectionname")
	@ResponseBody
	public String checkSectionname(String param) {
		return sectionService.checkSectionname(param);

	}

	@RequestMapping("/toUpdateSectionVo/{id}")
	public String toUpdateSectionVo(@PathVariable("id") Integer id, Model model) {
		SectionVo vo = sectionService.findById(id);
		model.addAttribute("vo", vo);
		return "branch/TbDiniSectionUpdate";
	}

	@RequestMapping("/updateSectionVo")
	public String updateSectionVo(SectionVo vo) {
		sectionService.updateSectionVo(vo);
		return "redirect:pageFindSection";
	}

	@RequestMapping("/deleteSectionVo")
	public String deleteSectionVo(Integer sectionid) {
		if (sectionid != null) {

			sectionService.deleteById(sectionid);
		}

		return "redirect:pageFindSection";
	}

}