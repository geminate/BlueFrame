package com.blueframe.frame.gen.model;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 业务表 对象
 */
public class GenScheme extends BaseEntity<GenScheme> {

	private String name; // 名称
	private String packageName; // 生成包路径
	private String moduleName; // 生成模块名
	private String functionName; // 生成功能名
	private GenTable genTable; // 业务表名
	private String functionAuthor; // 生成功能作者

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public GenTable getGenTable() {
		return genTable;
	}

	public void setGenTable(GenTable genTable) {
		this.genTable = genTable;
	}

	public String getFunctionAuthor() {
		return functionAuthor;
	}

	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor;
	}

}
