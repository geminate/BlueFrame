package com.blueframe.frame.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.base.dao.TreeDao;
import com.blueframe.frame.sys.model.SysPermission;

/**
 * 权限 Dao
 * @author hhLiu
 */
@Repository
public interface SysPermissionDao extends TreeDao<SysPermission> {

	/**
	 * 根据用户ID获得其权限列表
	 * @param sysUserId 用户ID
	 * @return 权限列表
	 */
	List<SysPermission> selectPermissionsByUser(String sysUserId);

	List<SysPermission> selectPermissionsByRole(String sysRoleId);

}
