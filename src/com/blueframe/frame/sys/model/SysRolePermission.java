package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.BaseEntity;

public class SysRolePermission extends BaseEntity<SysRolePermission> {
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
