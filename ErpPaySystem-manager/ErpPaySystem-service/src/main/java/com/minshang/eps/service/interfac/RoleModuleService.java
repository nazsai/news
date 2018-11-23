package com.minshang.eps.service.interfac;

import java.util.List;

public interface RoleModuleService {

	/**
	 * 根据角色id查询其拥有的所有菜单id
	 * @param roleId	角色id
	 * @return
	 */
	public List<Integer> findModuleIdsByRoleId(int roleId);
	
	/**
	 * 添加角色和菜单关系数据
	 * @param roleId	角色id
	 * @param moduleIds	菜单id字符串
	 */
	public void addRoleModuleRelation(int roleId, String moduleIds);
	
}
