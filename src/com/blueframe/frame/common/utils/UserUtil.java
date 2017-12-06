package com.blueframe.frame.common.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.blueframe.frame.common.tools.SpringContextHolder;
import com.blueframe.frame.sys.model.SysPermission;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysPermissionService;
import com.blueframe.frame.sys.service.SysRoleService;

/**
 * 用户相关 工具类
 * @author hhLiu
 */
public class UserUtil {

	private static SysRoleService sysRoleService = SpringContextHolder.getBean(SysRoleService.class);
	private static SysPermissionService sysPermissionService = SpringContextHolder.getBean(SysPermissionService.class);

	/**
	 * 获取当前登录用户对象
	 * @return 当前登录用户对象
	 */
	public static SysUser getCurrentUser() {
		if (SecurityUtils.getSubject() != null) {
			return (SysUser) SecurityUtils.getSubject().getPrincipal();
		}
		return null;
	}

	/**
	 * 获取当前登录用户的角色列表
	 * @return 当前登录用户的角色列表
	 */
	public static List<SysRole> getCurrentRoleList() {		
		return sysRoleService.selectRolesByUser(getCurrentUser().getId());
	}

	/**
	 * 获取当前登录用户的权限列表
	 * @return 当前登录用户的权限列表
	 */
	public static List<SysPermission> getCurrentPermissionList() {
		return sysPermissionService.selectPermissionsByUser(getCurrentUser().getId());
	}
}
