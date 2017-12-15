package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 角色 对象
 * @author hhLiu
 */
public class SysRole extends BaseEntity<SysRole> {
	
	private static final long serialVersionUID = 1L;

	private String name;
	private String roleStr;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleStr() {
		return roleStr;
	}

	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}
}