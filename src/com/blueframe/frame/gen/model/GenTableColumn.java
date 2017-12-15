package com.blueframe.frame.gen.model;

import java.util.ArrayList;
import java.util.List;

import com.blueframe.frame.base.model.BaseEntity;

public class GenTableColumn extends BaseEntity<GenTableColumn> {

	private GenTable genTable; // 归属表
	private String name; // 列名
	private String comments; // 注释
	private String jdbcType; // JDBC类型
	private String javaType; // JAVA类型
	private String javaField; // JAVA字段名
	private String isPk; // 是否主键（1：主键）
	private String isNull; // 是否可为空（1：可为空；0：不为空）
	private String isInsert; // 是否为插入字段（1：插入字段）
	private String isEdit; // 是否编辑字段（1：编辑字段）
	private String isList; // 是否列表字段（1：列表字段）
	private String isQuery; // 是否查询字段（1：查询字段）
	private String queryType; // 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
	private String showType; // 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
	private String dictType; // 字典类型
	private Integer sort; // 排序（升序）
	private String isSystem;// 是否是系统字段

	public GenTable getGenTable() {
		return genTable;
	}

	public void setGenTable(GenTable genTable) {
		this.genTable = genTable;
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

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaField() {
		return javaField;
	}

	public void setJavaField(String javaField) {
		this.javaField = javaField;
	}

	public String getIsPk() {
		return isPk;
	}

	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(String isInsert) {
		this.isInsert = isInsert;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getIsList() {
		return isList;
	}

	public void setIsList(String isList) {
		this.isList = isList;
	}

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}

	/**
	 * 获得简写的 JAVA 类型<br>
	 * java.util.Date --> Date
	 * @return 简写的 JAVA 类型
	 */
	public String getSimpleJavaType() {
		if (getJavaType().indexOf(".") != -1) {
			String reString[] = getJavaType().split("\\.");
			return reString[reString.length - 1];
		}
		return getJavaType();
	}

	public List<String> getAnnotationList() {
		List<String> list = new ArrayList<>();
		if ("java.util.Date".equals(getJavaType())) {
			list.add("@JsonFormat(pattern = \"yyyy-MM-dd\", timezone = \"GMT+8\")");
			list.add("@DateTimeFormat(pattern = \"yyyy-MM-dd\")");
		}
		return list;
	}
}
