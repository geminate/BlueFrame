package com.blueframe.frame.base.model;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import com.blueframe.frame.common.config.Global;
import com.blueframe.frame.sys.model.SysUser;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseEntity<T> {

	// 主键 ID
	protected String id;

	// 创建者
	protected SysUser createBy;

	// 创建日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date createDate;

	// 创建日期 查询 开始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date createDateBegin;

	// 创建日期 查询 结束日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date createDateEnd;

	// 更新者
	protected SysUser updateBy;

	// 更新日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date updateDate;

	// 更新日期 查询 开始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date updateDateBegin;

	// 更新日期 查询 开始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date updateDateEnd;

	// 删除标记（0：正常；1：删除；）
	protected String delFlag;

	// 分页对象
	private Page<T> page;

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

	public Date getCreateDateBegin() {
		return createDateBegin;
	}

	public void setCreateDateBegin(Date createDateBegin) {
		this.createDateBegin = createDateBegin;
	}

	public Date getCreateDateEnd() {
		// 结束日期 自动置为 当天最后一秒
		if (createDateEnd != null) {
			return new Date(createDateEnd.getTime() + (1000 * 60 * 60 * 24 - 1));
		} else {
			return null;
		}
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public Date getUpdateDateBegin() {
		return updateDateBegin;
	}

	public void setUpdateDateBegin(Date updateDateBegin) {
		this.updateDateBegin = updateDateBegin;
	}

	public Date getUpdateDateEnd() {
		if (updateDateEnd != null) {
			return new Date(updateDateEnd.getTime() + (1000 * 60 * 60 * 24 - 1));
		} else {
			return null;
		}
	}

	public void setUpdateDateEnd(Date updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}

	/**
	 * 获取 数据库类型
	 * @return
	 */
	public String getDbType() {
		return Global.getConfig("db.type");
	}

	/**
	 * 插入 预处理
	 * @param autoAddUUID
	 */
	public void preInsert(Boolean autoAddUUID) {
		this.setCreateBy(Global.getCurrentUser());
		this.setCreateDate(new Date());
		this.setUpdateBy(Global.getCurrentUser());
		this.setUpdateDate(new Date());
		this.setDelFlag("0");
		if (autoAddUUID) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			this.setId(uuid);
		}
	}

	/**
	 * 更新 预处理
	 */
	public void preUpdate() {
		this.setUpdateBy(Global.getCurrentUser());
		this.setUpdateDate(new Date());
		this.setDelFlag("0");
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
