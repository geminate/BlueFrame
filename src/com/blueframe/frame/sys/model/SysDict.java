package com.blueframe.frame.sys.model;

import javax.xml.bind.annotation.XmlAttribute;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 字典项管理 对象
 * @author hhLiu
 */
public class SysDict extends BaseEntity<SysDict> {

	private static final long serialVersionUID = 1L;

	private String label;// 标签名

	private String value;// 数据值
	
	private String enumName;// 枚举名

	private String type;// 分类

	private Long sort;// 排序

	private String description;// 简介

	@XmlAttribute
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@XmlAttribute
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	@XmlAttribute
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return label;
	}

}