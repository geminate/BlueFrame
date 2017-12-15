package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 用户 - 角色 对象
 * @author hhLiu
 */
public class SysUserRole extends BaseEntity<SysUserRole> {
	
	private static final long serialVersionUID = 1L;
	
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
