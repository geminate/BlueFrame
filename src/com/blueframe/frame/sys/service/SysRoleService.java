package com.blueframe.frame.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysRoleDao;
import com.blueframe.frame.sys.model.SysRole;

/**
 * 角色 Service
 * @author hhLiu
 */
@Service
public class SysRoleService extends BaseService<SysRoleDao, SysRole> {

	/**
	 * 根据用户ID获取其角色列表
	 * @param sysUserId 用户ID
	 * @return 角色列表
	 */
	public List<SysRole> selectRolesByUser(String sysUserId) {
		return dao.selectRolesByUser(sysUserId);
	}

}
