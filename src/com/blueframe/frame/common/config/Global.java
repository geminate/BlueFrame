package com.blueframe.frame.common.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;

import com.blueframe.frame.sys.model.SysUser;

/**
 * 全局 工具 类
 */
public class Global {

	private static PropertiesReader propertiesReader = new PropertiesReader("config.properties");

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = propertiesReader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	public static SysUser getCurrentUser() {
		if (SecurityUtils.getSubject() != null) {
			return (SysUser) SecurityUtils.getSubject().getPrincipal();
		}
		return null;
	}
}
