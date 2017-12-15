package com.blueframe.frame.gen.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.blueframe.frame.sys.model.SysDict;

/**
 * 代码生成器 配置文件 对象
 * @author hhLiu
 */
@XmlRootElement(name = "config")
public class GenConfig {

	private List<GenCategory> categoryList; // 生成分类
	private List<SysDict> javaTypeList; // java类型
	private List<SysDict> queryTypeList; // 查询类型
	private List<SysDict> showTypeList; // 显示类型

	@XmlElementWrapper(name = "category")
	@XmlElement(name = "category")
	public List<GenCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<GenCategory> categoryList) {
		this.categoryList = categoryList;
	}

	@XmlElementWrapper(name = "javaType")
	@XmlElement(name = "dict")
	public List<SysDict> getJavaTypeList() {
		return javaTypeList;
	}

	public void setJavaTypeList(List<SysDict> javaTypeList) {
		this.javaTypeList = javaTypeList;
	}

	@XmlElementWrapper(name = "queryType")
	@XmlElement(name = "dict")
	public List<SysDict> getQueryTypeList() {
		return queryTypeList;
	}

	public void setQueryTypeList(List<SysDict> queryTypeList) {
		this.queryTypeList = queryTypeList;
	}

	@XmlElementWrapper(name = "showType")
	@XmlElement(name = "dict")
	public List<SysDict> getShowTypeList() {
		return showTypeList;
	}

	public void setShowTypeList(List<SysDict> showTypeList) {
		this.showTypeList = showTypeList;
	}

}