package com.blueframe.frame.base.model;

import com.blueframe.common.config.Global;

import net.sf.json.JSONObject;

public class BaseEntity<T> {

	//分页对象
	private Page<T> page;

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	//数据库 类型
	public String getJdbcType() {
		return Global.getConfig("jdbc.type");
	}

	@Override
	public String toString() {
		JSONObject json = JSONObject.fromObject(this);
		return json.toString();
	}
}
