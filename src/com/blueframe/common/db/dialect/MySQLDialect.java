package com.blueframe.common.db.dialect;

/**
 * MySql 数据库方言
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
	 *
	 * @param sql    	原 Sql 语句
	 * @param start 	开始条数
	 * @param length  	每页显示条数
	 * @return 			分页查询的sql
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
