package com.blueframe.frame.common.freemarkers;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarker 工具类
 */
public class FreeMarkers {

	/**
	 * 填充 模板
	 * @param templateString 模板内容 字符串
	 * @param model 数据模型
	 * @return 填充后的 字符串
	 */
	public static String renderString(String templateString, Map<String, ?> model) {
		StringWriter result = new StringWriter();
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		try {
			Template t = new Template("name", new StringReader(templateString), configuration);
			t.process(model, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
