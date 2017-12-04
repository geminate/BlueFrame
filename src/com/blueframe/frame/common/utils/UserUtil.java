package com.blueframe.frame.common.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.blueframe.frame.common.tools.SpringContextHolder;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysPermissionService;
import com.blueframe.frame.sys.service.SysRoleService;
import com.blueframe.frame.sys.service.SysUserService;

public class UserUtil {

	private static SysUserService sysUserService = SpringContextHolder.getBean(SysUserService.class);
	private static SysRoleService sysRoleService = SpringContextHolder.getBean(SysRoleService.class);
	private static SysPermissionService sysPermissionService = SpringContextHolder.getBean(SysPermissionService.class);

	/**
	 * 获取当前登录用户
	 * @return 当前用户对象,未登录返回null
	 */
	public static SysUser getCurrentUser() {
		if (SecurityUtils.getSubject() != null) {
			return (SysUser) SecurityUtils.getSubject().getPrincipal();
		}
		return null;
	}

	public static List<SysRole> getCurrentRoleList() {
		return sysRoleService.selectRolesByUser(getCurrentUser().getId());
	}
}
