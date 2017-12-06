package com.blueframe.frame.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.TreeService;
import com.blueframe.frame.sys.dao.SysPermissionDao;
import com.blueframe.frame.sys.model.SysPermission;

/**
 * 权限 Service
 * @author hhLiu
 */
@Service
public class SysPermissionService extends TreeService<SysPermissionDao, SysPermission> {

	/**
	 * 根据用户ID获取其权限列表
	 * @param sysUserId 用户ID
	 * @return 权限列表
	 */
	public List<SysPermission> selectPermissionsByUser(String sysUserId) {
		return dao.selectPermissionsByUser(sysUserId);
	}

	/**
	 * 根据角色ID获取其权限列表
	 * @param sysRoleId
	 * @return
	 */
	public List<SysPermission> selectPermissionsByRole(String sysRoleId) {
		return dao.selectPermissionsByRole(sysRoleId);
	}
}
