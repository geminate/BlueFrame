package com.blueframe.frame.gen.model;

import com.blueframe.frame.base.model.BaseEntity;

public class GenTable extends BaseEntity<GenTable> {
	private String name;// 名称
	private String comments; // 描述
	private String className; // 实体类名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
