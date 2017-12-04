package com.blueframe.frame.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysUserRoleDao;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.model.SysUserRole;

/**
 * 用户 - 角色 Service
 * @author hhLiu
 */
@Service
public class SysUserRoleService extends BaseService<SysUserRoleDao, SysUserRole> {

	/**
	 * 为指定角色添加角色列表
	 * @param sysUser 用户对象
	 * @param roleList 要添加的角色列表
	 */
	public void bundleRolesToUser(SysUser sysUser, List<SysRole> roleList) {
		List<SysUserRole> sysUserRoleList = new ArrayList<>();
		if (roleList != null && !roleList.isEmpty()) {
			for (SysRole sysRole : roleList) {
				if (sysRole != null && sysRole.getId() != null && sysRole.getId() != "") {
					SysUserRole sysUserRole = new SysUserRole();
					sysUserRole.setSysUser(sysUser);
					sysUserRole.setSysRole(sysRole);
					sysUserRoleList.add(sysUserRole);
				}
			}
			insertBatch(sysUserRoleList, true);
		}
	}

	/**
	 * 删除指定用户的全部角色
	 * @param sysUser 用户对象
	 */
	public void deleteAllRolesByUser(SysUser sysUser) {
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setSysUser(sysUser);
		delete(sysUserRole, true);
	}
}
