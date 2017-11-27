package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.TreeEntity;

public class SysMenu extends TreeEntity<SysMenu> {

	private String name;
	private String href;
	private SysPermission permission;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public SysPermission getPermission() {
		return permission;
	}

	public void setPermission(SysPermission permission) {
		this.permission = permission;
	}

	@Override
	public SysMenu getParent() {
		return parent;
	}

	@Override
	public void setParent(SysMenu parent) {
		this.parent = parent;
	}

}
