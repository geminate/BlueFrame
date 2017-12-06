package com.blueframe.frame.common.tools;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Session缓存工具类
 * @author hhLiu
 */
public class SessionCacheTool {

	/**
	 * 获取 Shiro Session
	 * @return Session
	 */
	public static Session getSession() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		if (session == null) {
			session = subject.getSession();
		}
		return session;
	}

	/**
	 * 添加 Session 缓存
	 * @param key 键
	 * @param value 值
	 */
	public static void setCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 获取 Session 缓存
	 * @param key 键
	 * @return 值
	 */
	public static Object getCache(String key) {
		return getSession().getAttribute(key);
	}
}
