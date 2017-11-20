package com.blueframe.frame.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysPermissionDao;
import com.blueframe.frame.sys.model.SysPermission;

@Service
public class SysPermissionService extends BaseService<SysPermissionDao, SysPermission> {

	/**
	 * 获取 某个用户 的全部 权限
	 * @param sysUserId 用户 ID
	 * @return
	 */
	public List<SysPermission> selectPermissionsByUser(String sysUserId) {
		return dao.selectPermissionsByUser(sysUserId);
	}
}
