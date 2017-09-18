package com.blueframe.frame.gen.model;

import java.util.ArrayList;
import java.util.List;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 业务表 对象
 */
public class GenTable extends BaseEntity<GenTable> {
	private String name;// 名称
	private String comments; // 描述
	private String className; // 实体类名称

	private List<String> pkList = new ArrayList<>(); // 当前表主键列表

	private List<GenTableColumn> tableColumns = new ArrayList<>();;

	public GenTable() {
	}

	public GenTable(String id) {
		super.id = id;
	}

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

	public List<GenTableColumn> getTableColumns() {
		return tableColumns;
	}

	public void setTableColumns(List<GenTableColumn> tableColumns) {
		this.tableColumns = tableColumns;
	}

	public List<String> getPkList() {
		return pkList;
	}

	public void setPkList(List<String> pkList) {
		this.pkList = pkList;
	}
}
