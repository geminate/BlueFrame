package com.blueframe.frame.sys.dao;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.sys.model.SysUser;

@Repository
public class SysUserDao extends BaseDao<SysUser> {

	@Override
	public Class<SysUser> getEntityClass() {
		return SysUser.class;
	}
}
