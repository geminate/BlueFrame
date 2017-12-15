package com.blueframe.frame.gen.model;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 业务表 对象
 * @author hhLiu
 */
public class GenScheme extends BaseEntity<GenScheme> {

	private String name; // 方案名称
	private String packagePath; // 包路径
	private String modulePath; // 模块路径名
	private String moduleName; // 模块名称
	private String entityName; // 对象名称
	private GenTable genTable; // 业务表
	private String moduleAuthor; // 模块作者

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getModulePath() {
		return modulePath;
	}

	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public GenTable getGenTable() {
		return genTable;
	}

	public void setGenTable(GenTable genTable) {
		this.genTable = genTable;
	}

	public String getModuleAuthor() {
		return moduleAuthor;
	}

	public void setModuleAuthor(String moduleAuthor) {
		this.moduleAuthor = moduleAuthor;
	}

}
