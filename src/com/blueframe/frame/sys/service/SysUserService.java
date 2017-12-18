package com.blueframe.frame.sys.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysUserDao;
import com.blueframe.frame.sys.model.SysUser;

/**
 * 用户 Service
 * @author hhLiu
 */
@Service
public class SysUserService extends BaseService<SysUserDao, SysUser> {

	/**
	 * 根据用户名获取用户对象
	 * @param username 用户名
	 * @return 用户对象
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
