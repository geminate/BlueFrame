package com.blueframe.frame.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.sys.model.SysRole;

/**
 * 角色 Dao
 * @author hhLiu
 */
@Repository
public interface SysRoleDao extends BaseDao<SysRole> {

	/**
	 * 根据用户ID获取其角色列表
	 * @param sysUserId 用户ID
	 * @return 角色列表
	 */
	List<SysRole> selectRolesByUser(String sysUserId);
}
