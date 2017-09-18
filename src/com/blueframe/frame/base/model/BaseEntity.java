package com.blueframe.frame.base.model;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.blueframe.common.config.Global;
import com.blueframe.frame.sys.model.SysUser;

public class BaseEntity<T> {

	protected String id;// 主键Id
	protected SysUser createBy; // 创建者
	protected Date createDate; // 创建日期
	protected SysUser updateBy; // 更新者
	protected Date updateDate; // 更新日期
	protected String delFlag; // 删除标记（0：正常；1：删除；）

	private Page<T> page;// 分页对象
	protected SysUser currentUser;// 当前登录用户

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SysUser getCreateBy() {
		return createBy;
	}

	public void setCreateBy(SysUser createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public SysUser getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(SysUser updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public SysUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(SysUser currentUser) {
		this.currentUser = currentUser;
	}

	// 数据库 类型
	public String getDbType() {
		return Global.getConfig("db.type");
	}

	public void preInsert(Boolean autoAddUUID) {
		this.setCreateBy(new SysUser());
		this.setCreateDate(new Date());
		this.setUpdateBy(new SysUser());
		this.setUpdateDate(new Date());
		this.setDelFlag("0");
		if (autoAddUUID) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			this.setId(uuid);
		}
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
