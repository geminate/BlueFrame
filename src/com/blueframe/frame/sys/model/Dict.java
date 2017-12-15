package com.blueframe.frame.sys.model;

import javax.xml.bind.annotation.XmlAttribute;

import com.blueframe.frame.base.model.BaseEntity;

public class Dict extends BaseEntity<Dict> {

	private static final long serialVersionUID = 1L;

	private String value; // 数据值
	private String label; // 标签名
	private String type; // 类型
	private String description;// 描述
	private Integer sort; // 排序
	private String parentId;// 父Id

	@XmlAttribute
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlAttribute
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return label;
	}
}