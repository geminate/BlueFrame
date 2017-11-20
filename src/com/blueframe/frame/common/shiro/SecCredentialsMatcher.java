package com.blueframe.frame.common.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class SecCredentialsMatcher extends SimpleCredentialsMatcher {

	// 密码加密盐
	public static String salt = "SEC";

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object accountCredentials = getCredentials(info);
		String newpwd = encryptPassword(String.valueOf(token.getPassword()));
		return equals(newpwd, accountCredentials);
	}

	/**
	 * 密码加密方法
	 * @param password
	 * @return
	 */
	public static String encryptPassword(String password) {
		String newPassword = new SimpleHash("md5", password, ByteSource.Util.bytes(salt), 2).toHex();
		return newPassword;
	}

	public static void main(String[] args) {
		String password = "admin";
		System.out.println(encryptPassword(password));
	}
}
