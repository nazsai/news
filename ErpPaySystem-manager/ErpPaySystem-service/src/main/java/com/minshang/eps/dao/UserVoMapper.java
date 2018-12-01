package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.User;
import com.minshang.eps.vo.UserVo;

public interface UserVoMapper {

	int deleteByPrimaryKey(Integer userid);

	int insert(UserVo record);

	int insertSelective(UserVo record);

	UserVo selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(UserVo record);

	int updateByPrimaryKey(UserVo record);

	List<String> findRoles(Integer userid);

	/**
	 * 分页查询结果集
	 * 
	 * @param currPage 当前页
	 * @param pageSize 每页显示行数
	 * @param vo       查询条件
	 * @return
	 */
	List<UserVo> pageFind(@Param("currPage") int currPage, @Param("pageSize") int pageSize, @Param("vo") UserVo vo);

	/**
	 * 查询总条数
	 * 
	 * @param vo
	 * @return
	 */
	int pageFindCount(@Param("vo") UserVo vo);

	/**
	 * 添加一条成员
	 * 
	 * @param vo
	 */
	void addUserVo(UserVo vo);

	/**
	 * 根据主键ID修改状态
	 * 
	 * @param userid 主键id
	 * @param state  状态
	 */
	void updateStateById(@Param("userid") int userid, @Param("state") String state);
	/**
	 * 根据用户名查询条数
	 * @param username 用户民
	 * @return
	 */
	int getCountByUsername(String username);
	
	
	
	
		
	
	
	
	
	

}