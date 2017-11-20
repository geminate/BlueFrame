package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.BaseEntity;

public class SysUserRole extends BaseEntity<SysUserRole> {
	private SysUser sysUser;
	private SysRole sysRole;

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
}
