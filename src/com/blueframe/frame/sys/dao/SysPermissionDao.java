package com.blueframe.frame.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.sys.model.SysPermission;

@Repository
public interface SysPermissionDao extends BaseDao<SysPermission> {

	/**
	 * 获取 某个用户 的全部 权限
	 * @param sysUserId 用户 ID
	 * @return
	 */
	List<SysPermission> selectPermissionsByUser(String sysUserId);

}
