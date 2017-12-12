package com.blueframe.frame.sys.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.blueframe.frame.base.model.TreeEntity;

/**
 * 权限 对象
 * @author hhLiu
 */
public class SysPermission extends TreeEntity<SysPermission> {

	private String href;

	@NotEmpty(message = "权限标识不能为空")
	private String permissionStr;
	private String type;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPermissionStr() {
		return permissionStr;
	}

	public void setPermissionStr(String permissionStr) {
		this.permissionStr = permissionStr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public SysPermission getParent() {
		return parent;
	}

	@Override
	public void setParent(SysPermission parent) {
		this.parent = parent;
	}

}
