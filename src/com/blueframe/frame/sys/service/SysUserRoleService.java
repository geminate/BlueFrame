package com.blueframe.frame.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysUserRoleDao;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.model.SysUserRole;

@Service
public class SysUserRoleService extends BaseService<SysUserRoleDao, SysUserRole> {

	/**
	 * 将 多个 角色 绑定到 指定用户
	 * @param sysUser
	 * @param roleList
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
	 * 删除一个用户的 全部角色
	 * @param sysUser
	 */
	public void deleteAllRolesByUser(SysUser sysUser) {
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setSysUser(sysUser);
		delete(sysUserRole, true);
	}
}
