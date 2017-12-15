package com.blueframe.frame.gen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.model.GenTableColumn;

@Repository
public interface GenTableDao extends BaseDao<GenTable> {

	/**
	 * 获取 数据库中的 表信息
	 * @param genTable 筛选对象
	 * @return 数据库中的表信息列表
	 */
	List<GenTable> findTableListFromDb(GenTable genTable);

	/**
	 * 获取 表 的 列信息 列表
	 * @param genTable 筛选对象
	 * @return 列信息 列表
	 */
	List<GenTableColumn> findTableColumnFromDb(GenTable genTable);

	/**
	 * 获取 表 的 主键 列表
	 * @param genTable 筛选对象
	 * @return 主键 列表
	 */
	List<String> findTablePKListFromDb(GenTable genTable);

}
