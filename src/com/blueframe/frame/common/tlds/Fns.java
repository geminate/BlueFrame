package com.blueframe.frame.common.tlds;

import java.util.List;

import com.blueframe.frame.common.tools.SessionCacheTool;
import com.blueframe.frame.common.utils.ConfigUtil;
import com.blueframe.frame.common.utils.UserUtil;
import com.blueframe.frame.sys.model.SysPermission;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysUser;

/**
 * JSP TLD 实现类
 * @author hhLiu
 */
@SuppressWarnings("unchecked")
public class Fns {

	/**
	 * 获取配置文件value
	 * @param key 配置文件key
	 * @return 配置文件value
	 */
	public static String getConfig(String key) {
		return ConfigUtil.getConfig(key);
	}

	/**
	 * 获取当前登录用户对象
	 * @return 当前登录用户对象
	 */
	public static SysUser getCurrentUser() {
		SysUser currentUser = UserUtil.getCurrentUser();
		return currentUser;
	}

	/**
	 * 获取当前登录用户的角色列表
	 * @return 当前登录用户的角色列表
	 */
	public static List<SysRole> getCurrentRoleList() {
		if (SessionCacheTool.getCache("currentRoleList") != null) {
			return (List<SysRole>) SessionCacheTool.getCache("currentRoleList");
		} else {
			List<SysRole> currentRoleList = UserUtil.getCurrentRoleList();
			SessionCacheTool.setCache("currentRoleList", currentRoleList);
			return currentRoleList;
		}

	}

	/**
	 * 获取当前登录用户的权限列表
	 * @return 当前登录用户的权限列表
	 */
	public static List<SysPermission> getCurrentPermissionList() {
		if (SessionCacheTool.getCache("currentPermissionList") != null) {
			return (List<SysPermission>) SessionCacheTool.getCache("currentPermissionList");
		} else {
			List<SysPermission> currentPermissionList = UserUtil.getCurrentPermissionList();
			SessionCacheTool.setCache("currentPermissionList", currentPermissionList);
			return currentPermissionList;
		}
	}
}
