package com.blueframe.frame.common.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码加密类
 * @author hhLiu
 */
public class SecCredentialsMatcher extends SimpleCredentialsMatcher {

	/**
	 * 加密盐
	 */
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
	 * @param password 密码
	 * @return 加密后的密码
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
