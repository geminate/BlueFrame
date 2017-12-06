package com.blueframe.frame.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.sys.dao.SysRolePermissionDao;
import com.blueframe.frame.sys.model.SysPermission;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysRolePermission;

/**
 * 角色 - 权限 Service
 * @author hhLiu
 */
@Service
public class SysRolePermissionService extends BaseService<SysRolePermissionDao, SysRolePermission> {

	/**
	 * 为指定角色添加权限列表
	 * @param sysRole 角色对象
	 * @param permissionList 权限列表
	 */
	public void bundlePermissionsToRole(SysRole sysRole, List<SysPermission> permissionList) {
		List<SysRolePermission> sysRolePermissionList = new ArrayList<>();
		if (permissionList != null && !permissionList.isEmpty()) {
			for (SysPermission sysPermission : permissionList) {
				if (sysPermission != null && sysPermission.getId() != null && sysPermission.getId() != "") {
					SysRolePermission sysRolePermission = new SysRolePermission();
					sysRolePermission.setSysPermission(sysPermission);
					sysRolePermission.setSysRole(sysRole);
					sysRolePermissionList.add(sysRolePermission);
				}
			}
			insertBatch(sysRolePermissionList, true);
		}
	}

	/**
	 * 为指定角色添加权限列表
	 * @param sysRole 角色对象
	 * @param sysPermissionIdStr 权限ID字符串 用,分割
	 */
	public void bundlePermissionsToRole(SysRole sysRole, String sysPermissionIdStr) {
		if (sysPermissionIdStr != null && sysPermissionIdStr != "") {
			List<SysRolePermission> sysRolePermissionList = new ArrayList<>();
			String[] sysPermissionIdArray = sysPermissionIdStr.split(",");
			for (String id : sysPermissionIdArray) {
				SysRolePermission sysRolePermission = new SysRolePermission();
				SysPermission sysPermission = new SysPermission();
				sysPermission.setId(id);
				sysRolePermission.setSysPermission(sysPermission);
				sysRolePermission.setSysRole(sysRole);
				sysRolePermissionList.add(sysRolePermission);
			}
			insertBatch(sysRolePermissionList, true);
		}
	}

	/**
	 * 删除 指定角色的 全部权限
	 * @param sysRole 角色对象
	 */
	public void deleteAllPermissionsByRole(SysRole sysRole) {
		if (sysRole != null && sysRole.getId() != null && sysRole.getId() != "") {
			SysRolePermission sysRolePermission = new SysRolePermission();
			sysRolePermission.setSysRole(sysRole);
			delete(sysRolePermission, false);// 这里是 物理删除
		}
	}
}
