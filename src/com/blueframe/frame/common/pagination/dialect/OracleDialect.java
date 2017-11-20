package com.blueframe.frame.common.pagination.dialect;

/**
 * Oracle 数据库方言
 */
public class OracleDialect implements Dialect {

	/**
	 * Oracle 数据库 支持 分页功能
	 */
	@Override
	public boolean supportsLimit() {
		return true;
	}

	/**
	 * 获取 分页 Sql 语句
	 * @param sql    	原 Sql 语句
	 * @param start 	开始条数
	 * @param length  	每页显示条数
	 * @return 			分页查询的sql
	 */
	@Override
	public String getLimitString(String sql, int start, int length) {
		sql = sql.trim();
		boolean isForUpdate = false;

		//是否 加锁 判断
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}
		StringBuilder pagingSelect = new StringBuilder(sql.length() + 100);

		if (start > 0) {
			pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		} else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (start > 0) {
			String endString = Integer.toString(start) + "+" + length;
			pagingSelect.append(" ) row_ where rownum <= " + endString + ") where rownum_ > ").append(Integer.toString(start));
		} else {
			pagingSelect.append(" ) where rownum <= " + length);
		}

		if (isForUpdate) {
			pagingSelect.append(" for update");
		}

		return pagingSelect.toString();
	}

}
