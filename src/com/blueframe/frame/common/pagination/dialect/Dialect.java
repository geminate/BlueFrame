package com.blueframe.frame.common.pagination.dialect;

/**
 * 数据库方言接口
 */
public interface Dialect {

	/**
	 * 数据库 是否支持分页
	 * 如不支持 则不进行分页
	 * @return
	 */
	public boolean supportsLimit();

	/**
	 * 获取 分页 Sql 语句
	 *
	 * @param sql    	原 Sql 语句
	 * @param start 	开始条数
	 * @param length  	每页显示条数
	 * @return 			分页查询的sql
	 */
	public String getLimitString(String sql, int start, int length);

}
