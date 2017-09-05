package com.blueframe.frame.sys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysUserDao;
import com.blueframe.frame.sys.model.SysUser;

@Service
public class SysUserService extends BaseService<SysUser> {

	@Resource
	private SysUserDao sysUserDao;

	@Override
	public BaseDao<SysUser> getDao() {
		return sysUserDao;
	}

}
