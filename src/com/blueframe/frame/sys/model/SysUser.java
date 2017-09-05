package com.blueframe.frame.sys.model;

import com.blueframe.frame.base.model.BaseEntity;

public class SysUser extends BaseEntity<SysUser> {
	private String id;
	private String username;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
