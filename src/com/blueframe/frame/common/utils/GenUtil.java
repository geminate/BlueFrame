package com.blueframe.frame.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.blueframe.frame.common.component.freemarkers.FreeMarkers;
import com.blueframe.frame.common.tools.JaxbUtil;
import com.blueframe.frame.common.tools.StringUtils;
import com.blueframe.frame.gen.model.GenCategory;
import com.blueframe.frame.gen.model.GenConfig;
import com.blueframe.frame.gen.model.GenScheme;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.model.GenTableColumn;
import com.blueframe.frame.gen.model.GenTemplate;
import com.blueframe.frame.sys.model.SysUser;

/**
 * 代码生成 工具类
 * @author hhLiu
 */
public class GenUtil {

	private static Logger logger = LoggerFactory.getLogger(GenUtil.class);

	/**
	 * 初始化 列信息
	 * @param genTable 表信息
	 */
	public static void initColumnField(GenTable genTable) {

		List<GenTableColumn> genTableColumns = genTable.getTableColumns();

		for (GenTableColumn column : genTableColumns) {

			// 若字段 无注释，则将列名作为注释
			if (StringUtils.isBlank(column.getComments())) {
				column.setComments(column.getName());
			}

			// 设置java类型：
			if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "CHAR") || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "VARCHAR")
					|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NARCHAR")) {
				column.setJavaType("String");
			} else if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATETIME") || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATE")
					|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "TIMESTAMP")) {
				column.setJavaType("java.util.Date");
				column.setShowType("dateselect");
			} else if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "INT") || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "BIGINT")
					|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NUMBER")) {
				// 如果是浮点型
				String[] ss = StringUtils.split(StringUtils.substringBetween(column.getJdbcType(), "(", ")"), ",");
				if (ss != null && ss.length == 2 && Integer.parseInt(ss[1]) > 0) {
					column.setJavaType("Double");
				}
				// 如果是整形
				else if (ss != null && ss.length == 1 && Integer.parseInt(ss[0]) <= 10) {
					column.setJavaType("Integer");
				}
				// 长整形
				else {
					column.setJavaType("Long");
				}
			}

			// 设置java字段名
			column.setJavaField(StringUtils.toCamelCase(column.getName()));

			// 是否是主键
			column.setIsPk(genTable.getPkList().contains(StringUtils.lowerCase(column.getName())) ? "1" : "0");

			// 插入、编辑字段
			column.setIsInsert("1");
			column.setIsEdit("1");
			column.setIsList("1");
			column.setIsQuery("1");

			// 设置特定类型和字段名
			// ID
			if (StringUtils.startsWithIgnoreCase(column.getName(), "id")) {
				column.setIsSystem("1");
				column.setIsInsert("0");
				column.setIsEdit("0");
				column.setIsList("0");
				column.setIsQuery("0");
			}

			// 创建者、更新者
			if (StringUtils.startsWithIgnoreCase(column.getName(), "create_by") || StringUtils.startsWithIgnoreCase(column.getName(), "update_by")) {
				column.setJavaType(SysUser.class.getName());
				column.setJavaField(column.getJavaField() + ".id");
				column.setIsSystem("1");
				column.setIsInsert("0");
				column.setIsEdit("0");
				column.setIsList("0");
				column.setIsQuery("0");
			}
			// 创建时间、更新时间
			else if (StringUtils.startsWithIgnoreCase(column.getName(), "create_date") || StringUtils.startsWithIgnoreCase(column.getName(), "update_date")) {
				column.setShowType("dateselect");
				column.setIsSystem("1");
				column.setIsInsert("0");
				column.setIsEdit("0");
				column.setIsList("0");
				column.setIsQuery("0");
			}
			// 删除标记
			else if (StringUtils.equalsIgnoreCase(column.getName(), "del_flag")) {
				column.setShowType("radiobox");
				column.setDictType("del_flag");
				column.setIsSystem("1");
				column.setIsInsert("0");
				column.setIsEdit("0");
				column.setIsList("0");
				column.setIsQuery("0");
			}
		}
	}

	/**
	 * 获取代码生成配置对象
	 * @return 配置对象
	 */
	public static GenConfig getConfig() {
		return fileToObject("/frame/gen/genConfig.xml", GenConfig.class);
	}

	/**
	 * XML文件转换为对象
	 * @param pathName XML文件地址
	 * @param clazz 对象类
	 * @param <T> T
	 * @return 转换后的对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fileToObject(String pathName, Class<?> clazz) {
		try {
			Resource resource = new ClassPathResource(pathName);
			InputStream is = resource.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line).append("\r\n");
			}
			if (is != null) {
				is.close();
			}
			if (br != null) {
				br.close();
			}
			return (T) JaxbUtil.fromXml(sb.toString(), clazz);
		} catch (IOException e) {
			logger.warn("读取 代码生成器 配置文件错误，文件路径：" + pathName + ",错误信息：" + e.getMessage());
		}
		return null;
	}

	public static List<GenTemplate> getTemplateList(GenConfig config, boolean b) {
		List<GenTemplate> templateList = new ArrayList<>();
		if (config != null && config.getCategoryList() != null) {
			for (GenCategory e : config.getCategoryList()) {
				List<String> strings = e.getTemplate();
				for (String s : strings) {
					GenTemplate template = fileToObject(s, GenTemplate.class);
					templateList.add(template);
				}
			}
		}
		return templateList;
	}

	public static Map<String, Object> getDataModelNew(GenScheme genScheme) {
		Map<String, Object> model = new HashMap<String, Object>();

		// 包路径：cn.ac.sec
		model.put("packagePath", StringUtils.lowerCase(genScheme.getPackagePath()));

		// 模块路径名：test
		model.put("modulePath", StringUtils.lowerCase(genScheme.getModulePath()));

		// 模块说明：测试模块
		model.put("moduleName", genScheme.getModuleName());

		// 模块作者：hhLiu
		model.put("moduleAuthor", genScheme.getModuleAuthor());

		// 类名：ProjectTest
		model.put("ClassName", StringUtils.capitalize(genScheme.getGenTable().getClassName()));

		// 首字母小写类名：projectTest
		model.put("className", StringUtils.uncapitalize(genScheme.getGenTable().getClassName()));

		// Table 表
		model.put("table", genScheme.getGenTable());

		// Colomn 列表
		model.put("columns", genScheme.getGenTable().getTableColumns());

		// 根访问地址：test/projectTest
		model.put("url", ((String) model.get("modulePath")).replace(".", "/") + "/" + model.get("className"));

		return model;
	}

	public static void generateToFile(GenTemplate tpl, Map<String, Object> model) {
		String projectPath = ConfigUtil.getConfig("projectPath");
		String filePath = FreeMarkers.renderString(tpl.getFilePath(), model).replace(".", "\\");
		String fileName = FreeMarkers.renderString(tpl.getFileName(), model);
		String outPathString = projectPath + File.separator + filePath + File.separator + fileName;
		String content = FreeMarkers.renderString(StringUtils.trimToEmpty(tpl.getContent()), model);
		try {
			FileUtils.writeStringToFile(new File(outPathString), content, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}
}
