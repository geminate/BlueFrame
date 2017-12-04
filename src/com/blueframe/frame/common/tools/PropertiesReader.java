package com.blueframe.frame.common.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 配置文件 读取 工具类
 * @author hhLiu
 */
public class PropertiesReader {

	private static Logger logger = LoggerFactory.getLogger(PropertiesReader.class);

	private static ResourceLoader resourceLoader = new DefaultResourceLoader();

	private final Properties properties;

	public PropertiesReader(String... resourcesPaths) {
		properties = loadProperties(resourcesPaths);
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * 获取 属性 的 值
	 * @param key 属性名
	 * @return 属性对应的value
	 */
	public String getProperty(String key) {
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return "";
	}

	/**
	 * 载入配置文件
	 * @param resourcesPaths 配置文件路径
	 * @return 配置文件对象
	 */
	private Properties loadProperties(String... resourcesPaths) {
		Properties props = new Properties();
		for (String location : resourcesPaths) {
			InputStream is = null;
			try {
				Resource resource = resourceLoader.getResource(location);
				is = resource.getInputStream();
				props.load(is);
			} catch (IOException ex) {
				logger.info("Could not load properties from path:" + location + ", " + ex.getMessage());
			} finally {
				IOUtils.closeQuietly(is);
			}
		}
		return props;
	}
}
