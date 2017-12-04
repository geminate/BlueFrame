package com.blueframe.frame.common.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.blueframe.frame.sys.model.SysPermission;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysPermissionService;
import com.blueframe.frame.sys.service.SysRoleService;
import com.blueframe.frame.sys.service.SysUserService;

/**
 * Shiro 登录验证类
 * @author hhLiu
 */
public class SecShiroRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 权限、角色获取方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser token = (SysUser) SecurityUtils.getSubject().getPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		List<SysRole> roleList = sysRoleService.selectRolesByUser(token.getId());
		for (SysRole sysRole : roleList) {
			authorizationInfo.addRole(sysRole.getRoleStr());
		}
		List<SysPermission> permissionList = sysPermissionService.selectPermissionsByUser(token.getId());
		for (SysPermission sysPermission : permissionList) {
			authorizationInfo.addStringPermission(sysPermission.getPermissionStr());
		}
		return authorizationInfo;
	}

	/**
	 * 登录验证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;
		String username = utoken.getUsername();
		SysUser sysUser = sysUserService.selectOneByUsername(username);
		if (sysUser == null) {
			throw new AccountException("帐号或密码不正确！");
		}
		return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), ByteSource.Util.bytes(SecCredentialsMatcher.salt), getName());
	}

}
