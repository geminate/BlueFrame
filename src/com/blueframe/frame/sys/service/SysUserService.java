package com.blueframe.frame.sys.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysUserDao;
import com.blueframe.frame.sys.model.SysUser;

@Service
public class SysUserService extends BaseService<SysUserDao, SysUser> {

	/**
	 * 根据 用户名 查询 单个 用户
	 * @param username
	 * @return
	 */
	public SysUser selectOneByUsername(String username) {
		if (StringUtils.isNotEmpty(username)) {
			SysUser sysUser = new SysUser();
			sysUser.setUsername(username);
			return selectOne(sysUser, false);
		} else {
			return null;
		}
	}

}
