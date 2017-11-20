package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.BaseEntity;

public class SysPermission extends BaseEntity<SysPermission> {

	private String name;
	private String permissionStr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissionStr() {
		return permissionStr;
	}

	public void setPermissionStr(String permissionStr) {
		this.permissionStr = permissionStr;
	}

}
