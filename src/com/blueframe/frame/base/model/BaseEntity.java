package com.blueframe.frame.base.model;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import com.blueframe.frame.common.utils.ConfigUtil;
import com.blueframe.frame.common.utils.UserUtil;
import com.blueframe.frame.sys.model.SysUser;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 对象 基类<br>
 * 数据库中 需至少包含 id,create_by,create_date,update_by,update_date,del_flag 字段
 * @author hhLiu
 */
public class BaseEntity<T> {

	/**
	 * 主键ID
	 */
	protected String id;

	/**
	 * 创建人
	 */
	protected SysUser createBy;

	/**
	 * 创建日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date createDate;

	/**
	 * 查询时的 创建日期 起始日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date createDateBegin;

	/**
	 * 查询时的 创建日期 结束日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date createDateEnd;

	/**
	 * 更信人
	 */
	protected SysUser updateBy;

	/**
	 * 更新日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date updateDate;

	/**
	 * 查询时的 更新日期 起始日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date updateDateBegin;

	/**
	 * 查询时的 更新日期 结束日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date updateDateEnd;

	/**
	 * 删除标记<br>
	 * 0 表示正常 , 1 表示删除
	 */
	protected String delFlag;

	/**
	 * 分页对象
	 * @see Page
	 */
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

	/**
	 * 查询时自动将 创建日期 的 结束日期置为 当天 最后一秒<br>
	 * 例如查询2012-12-12 至 2012-12-12 需要将结束日期 置为当天最后一秒
	 * @return 查询结束日期(所选当天的最后一秒)
	 */
	public Date getCreateDateEnd() {
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

	/**
	 * 查询时自动将 更新日期 的 结束日期置为 当天 最后一秒<br>
	 * 例如查询2012-12-12 至 2012-12-12 需要将结束日期 置为当天最后一秒
	 * @return 查询结束日期(所选当天的最后一秒)
	 */
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
	 * 获取 数据库类型,便于Mybatis的Xml中判断数据库类型
	 * @return 配置文件中数据库类型
	 */
	public String getDbType() {
		return ConfigUtil.getConfig("db.type");
	}

	/**
	 * 对象插入前的预处理<br>
	 * 添加 创建人、创建时间、更新人、更新时间、删除标记为0、自动生成ID(可选)
	 * @param autoAddUUID 是否自动生成ID
	 */
	public void preInsert(Boolean autoAddUUID) {
		this.setCreateBy(UserUtil.getCurrentUser());
		this.setCreateDate(new Date());
		this.setUpdateBy(UserUtil.getCurrentUser());
		this.setUpdateDate(new Date());
		this.setDelFlag("0");
		if (autoAddUUID) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			this.setId(uuid);
		}
	}

	/**
	 * 对象更新前的预处理<br>
	 * 添加 更新人、更新日期、删除标记为0
	 */
	public void preUpdate() {
		this.setUpdateBy(UserUtil.getCurrentUser());
		this.setUpdateDate(new Date());
		this.setDelFlag("0");
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
