package com.blueframe.frame.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.sys.model.SysDict;
import com.blueframe.frame.base.dao.BaseDao;

/**
 * 字典项管理 Dao
 * @author hhLiu
 */
@Repository
public interface SysDictDao extends BaseDao<SysDict> {

	/**
	 * 获取全部 字典项类型
	 * @return 全部 字典项类型列表
	 */
	public List<String> selectAllTypeList();

}