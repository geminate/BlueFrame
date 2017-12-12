package com.blueframe.frame.base.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 树结构对象 基类<br>
 * 数据库中 需至少包含 name,parent_id,parent_ids 字段<br>
 * 需要初始化一条  id 为1, parent_id 为0 的根节点
 * @author hhLiu
 */
public abstract class TreeEntity<T> extends BaseEntity<T> {

	/**
	 * 节点名称
	 */
	@NotEmpty(message = "名称不能为空")
	protected String name;

	/**
	 * 父节点ID
	 */
	protected String parentId;

	/**
	 * 父节点对象
	 */	
	protected T parent;

	/**
	 * 全部父节点ID字符串,用","分割<br>
	 * 0,1,46fea28a5f1f4ac1a7e74ee1a30f750a,
	 */
	protected String parentIds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public abstract T getParent();

	public abstract void setParent(T parent);

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
}
