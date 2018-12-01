package com.minshang.eps.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minshang.eps.service.interfac.UserVoService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.UserVo;

@Controller
public class UserVoController {
	@Autowired
	private UserVoService userVoService;

	@RequestMapping("/pageFindUserVo")
	public String pageFind(@RequestParam(defaultValue = "1", required = false) Integer currPage,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize, UserVo vo, Model model) {
		PageResult<UserVo> page = userVoService.pageFind(currPage, pageSize, vo);
		model.addAttribute("page", page);
		model.addAttribute("vo", vo);
		return "person/UserList";
	}

	@RequestMapping("/toAddUserVo")
	public String toAddUserVo() {
		return "person/toAddUserVo";
	}

	@RequestMapping("/addUserVo")
	public String addUserVo(UserVo vo) {
		userVoService.addUserVo(vo);
		return "redirect:pageFindUserVo";
	}

	@RequestMapping("/checkUsername")
	@ResponseBody
	public String checkUsername(String param) {
		return userVoService.checkUsername(param);
	}

	@RequestMapping("/toUpdateUserVo/{userid}")
	public String toUpdateUserVo(@PathVariable Integer userid, Model modle) {
		System.out.println(userid);
		UserVo vo = userVoService.findById(userid);
		modle.addAttribute("vo", vo);
		return "person/updateUserVo";
	}

	@RequestMapping("/updateUserVo")
	public String updateUserVo(UserVo vo) {
		userVoService.updateUserVo(vo);
		return "redirect:pageFindUserVo";

	}
	@RequestMapping("/deleteUserVo")
	public String deleteUserVo(Integer userid) {
		userVoService.deleteById(userid);
		return"redirect:pageFindUserVo";
		
	}
}