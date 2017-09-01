package com.blueframe.modules.sys.model;

import net.sf.json.JSONObject;

public class BaseEntity<T> {

	private Page<T> page;

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	@Override
	public String toString() {
		JSONObject json = JSONObject.fromObject(this);
		return json.toString();
	}
}
