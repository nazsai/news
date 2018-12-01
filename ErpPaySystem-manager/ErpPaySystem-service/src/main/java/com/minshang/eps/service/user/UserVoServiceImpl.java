package com.minshang.eps.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.UserMapper;
import com.minshang.eps.dao.UserVoMapper;
import com.minshang.eps.entity.User;
import com.minshang.eps.service.interfac.UserService;
import com.minshang.eps.service.interfac.UserVoService;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.UserVo;

/**
 * 员工信息业务层
 * @author Administrator
 *
 */
@Service
public class UserVoServiceImpl implements UserVoService {

	@Autowired
	private UserVoMapper userVoMapper;

	@Override
	public PageResult<UserVo> pageFind(int currPage, int pageSize, UserVo vo) {
		//查询结果集
		List<UserVo> list = userVoMapper.pageFind(currPage, pageSize, vo);
		//查询总行数
		int totalNum = userVoMapper.pageFindCount(vo);
		//封装	
		return new PageResult<UserVo>(currPage, pageSize, totalNum, list);
	}

	@Override
	public void addUserVo(UserVo vo) {
		userVoMapper.insert(vo);	
	}

	@Override
	public String checkUsername(String username) {
		int count = userVoMapper.getCountByUsername(username);
		if (count > 1) {
			return "该机构已存在！";
		}else {
			return "y";
		}	
	}

	@Override
	public UserVo findById(int userid) {
		return userVoMapper.selectByPrimaryKey(userid);
	}

	@Override
	public void updateUserVo(UserVo vo) {
		userVoMapper.updateByPrimaryKeySelective(vo);
		
	}

	@Override
	public void deleteById(int userid) {
		final String state = "1";
		userVoMapper.updateStateById(userid, state);
		
	}

	




	
   

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
