package com.blueframe.frame.common.tools;

import java.util.HashMap;
import java.util.Map;

import com.blueframe.frame.sys.model.SysUser;

/**
 * 内存缓存工具类
 * @author hhLiu
 */
public class MemoryCacheTool {

	// 全局 内存 缓存
	private static Map<String, Object> globalCache = new HashMap<String, Object>();

	// 用户 内存 缓存
	private static Map<String, Map<String, Object>> userCache = new HashMap<String, Map<String, Object>>();

	/**
	 * 添加 全局缓存
	 * @param key 键
	 * @param value 值
	 */
	public static void setGlobalCache(String key, Object value) {
		globalCache.put(key, value);
	}

	/**
	 * 获取 全局缓存
	 * @param key 键
	 * @return 值
	 */
	public static Object getGlobalCache(String key) {
		return globalCache.get(key);
	}

	/**
	 * 添加 用户缓存
	 * @param sysUser 用户对象
	 * @param key 键
	 * @param value 值
	 */
	public static void setUserCache(SysUser sysUser, String key, Object value) {
		if (userCache.get(sysUser.getId()) == null) {
			userCache.put(sysUser.getId(), new HashMap<String, Object>());
		}
		userCache.get(sysUser.getId()).put(key, value);
	}

	/**
	 * 获取 用户缓存
	 * @param sysUser 用户对象
	 * @param key 键
	 * @return 值
	 */
	public static Object getUserCache(SysUser sysUser, String key) {
		if (userCache.get(sysUser.getId()) == null) {
			return null;
		} else {
			return userCache.get(sysUser.getId()).get(key);
		}
	}

	/**
	 * 清空全部全局缓存
	 */
	public static void cleanAllGlobalCache() {
		globalCache.clear();
	}

	/**
	 * 清空指定全局缓存
	 * @param key 键
	 */
	public static void cleanGlobalCache(String key) {
		globalCache.remove(key);
	}

	/**
	 * 清空指定用户的指定缓存
	 * @param sysUser 用户对象
	 * @param key 键
	 */
	public static void cleanUserOneCache(SysUser sysUser, String key) {
		if (userCache.get(sysUser.getId()) != null) {
			userCache.get(sysUser.getId()).remove(key);
		}
	}

	/**
	 * 清空指定用户缓存
	 * @param sysUser 用户对象
	 */
	public static void cleanUserCache(SysUser sysUser) {
		userCache.remove(sysUser.getId());
	}

	/**
	 * 清空全部用户缓存
	 */
	public static void cleanAllUserCache() {
		userCache.clear();
	}

	/**
	 * 清空全部缓存
	 */
	public static void cleanAllCache() {
		globalCache.clear();
		userCache.clear();
	}
}
