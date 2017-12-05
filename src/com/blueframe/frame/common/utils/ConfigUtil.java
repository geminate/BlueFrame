package com.blueframe.frame.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.blueframe.frame.common.tools.PropertiesReader;

/**
 * 配置文件 工具类
 * @author hhLiu
 */
public class ConfigUtil {

	private static PropertiesReader propertiesReader = new PropertiesReader("config.properties");

	private static Map<String, String> map = new HashMap<String, String>();

	/**
	 * 获取配置文件value
	 * @param key 配置文件key
	 * @return 配置文件value
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = propertiesReader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
}