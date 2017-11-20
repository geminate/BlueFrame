package com.blueframe.frame.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysRoleDao;
import com.blueframe.frame.sys.model.SysRole;

@Service
public class SysRoleService extends BaseService<SysRoleDao, SysRole> {

	/**
	 * 获取 某个用户的 全部角色
	 * @param sysUserId 用户ID
	 * @return
	 */
	public List<SysRole> selectRolesByUser(String sysUserId) {
		return dao.selectRolesByUser(sysUserId);
	}

}
