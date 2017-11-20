package com.blueframe.frame.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.sys.model.SysRole;

@Repository
public interface SysRoleDao extends BaseDao<SysRole> {

	/**
	 * 获取 某个用户的 全部角色
	 * @param sysUserId 用户ID
	 * @return
	 */
	List<SysRole> selectRolesByUser(String sysUserId);
}
