package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 角色 - 权限 对象
 * @author hhLiu
 */
public class SysRolePermission extends BaseEntity<SysRolePermission> {
	
	private static final long serialVersionUID = 1L;
	
	private SysRole sysRole;
	private SysPermission sysPermission;

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysPermission getSysPermission() {
		return sysPermission;
	}

	public void setSysPermission(SysPermission sysPermission) {
		this.sysPermission = sysPermission;
	}
}
