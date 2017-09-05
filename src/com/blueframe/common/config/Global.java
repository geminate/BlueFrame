package com.blueframe.common.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.blueframe.common.tools.PropertiesReader;

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

	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}

	
}
