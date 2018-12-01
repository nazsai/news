package com.minshang.eps.service.interfac;

import com.minshang.eps.util.PageResult;
import com.minshang.eps.vo.UserVo;

/**
 * 用户登录业务层接口
 * @author Administrator
 *
 */
public interface UserVoService {

	/**
	 * 分页查询
	 * @param currPage 当前页
	 * @param pageSize 当前行
	 * @param vo 条件
	 * @return
	 */
	PageResult<UserVo>pageFind(int currPage,int pageSize,UserVo vo);
	
	/**
	 * 添加一个成员
	 * @param vo
	 */
	void addUserVo(UserVo vo);
	
	/**
	 * 判断用户名是否重复
	 * @param username 用户名
	 * @return
	 */
	String checkUsername(String username);
	
	/**
	 * 	根据主键获取一条用户信息
	 * @param userid
	 * @return
	 */
	UserVo findById(int userid);
	/**
	 * 修改一条参数
	 * @param vo
	 */
	void updateUserVo(UserVo vo);
	
	/**
	 * 根据id修改状态
	 * @param userid
	 */
	void deleteById(int userid);
	
	
	
	
	
}
