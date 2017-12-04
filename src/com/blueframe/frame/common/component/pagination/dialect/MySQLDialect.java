package com.blueframe.frame.common.component.pagination.dialect;

/**
 * MySql 数据库方言 类
 * @author hhLiu
 */
public class MySQLDialect implements Dialect {

	/**
	 * MySQL 数据库 支持分页功能
	 */
	@Override
	public boolean supportsLimit() {
		return true;
	}

	/**
	 * 获取 分页 Sql 语句
	 */
	@Override
	public String getLimitString(String sql, int offset, int limit) {
		StringBuilder stringBuilder = new StringBuilder(sql);
		stringBuilder.append(" limit ");
		if (offset > 0) {
			stringBuilder.append(Integer.toString(offset)).append(",").append(Integer.toString(limit));
		} else {
			stringBuilder.append(Integer.toString(limit));
		}
		return stringBuilder.toString();
	}

}
