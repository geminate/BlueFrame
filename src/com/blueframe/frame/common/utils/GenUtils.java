package com.blueframe.frame.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.blueframe.frame.common.config.Global;
import com.blueframe.frame.common.freemarkers.FreeMarkers;
import com.blueframe.frame.gen.model.GenCategory;
import com.blueframe.frame.gen.model.GenConfig;
import com.blueframe.frame.gen.model.GenScheme;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.model.GenTableColumn;
import com.blueframe.frame.gen.model.GenTemplate;
import com.blueframe.frame.sys.model.SysUser;

/**
 * 代码生成 工具类
 */
public class GenUtils {

	private static Logger logger = LoggerFactory.getLogger(GenUtils.class);

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

			// 插入字段
			column.setIsInsert("1");

			// 编辑字段
			if (!StringUtils.equalsIgnoreCase(column.getName(), "id") && !StringUtils.equalsIgnoreCase(column.getName(), "create_by")
					&& !StringUtils.equalsIgnoreCase(column.getName(), "create_date") && !StringUtils.equalsIgnoreCase(column.getName(), "del_flag")) {
				column.setIsEdit("1");
			}

			// 列表字段
			if (StringUtils.equalsIgnoreCase(column.getName(), "name") || StringUtils.equalsIgnoreCase(column.getName(), "title")
					|| StringUtils.equalsIgnoreCase(column.getName(), "remarks") || StringUtils.equalsIgnoreCase(column.getName(), "update_date")) {
				column.setIsList("1");
			}

			// 查询字段
			if (StringUtils.equalsIgnoreCase(column.getName(), "name") || StringUtils.equalsIgnoreCase(column.getName(), "title")) {
				column.setIsQuery("1");
			}

			// 查询字段类型
			if (StringUtils.equalsIgnoreCase(column.getName(), "name") || StringUtils.equalsIgnoreCase(column.getName(), "title")) {
				column.setQueryType("like");
			}

			// 设置特定类型和字段名
			// 创建者、更新者
			if (StringUtils.startsWithIgnoreCase(column.getName(), "create_by") || StringUtils.startsWithIgnoreCase(column.getName(), "update_by")) {
				column.setJavaType(SysUser.class.getName());
				column.setJavaField(column.getJavaField() + ".id");
			}
			// 创建时间、更新时间
			else if (StringUtils.startsWithIgnoreCase(column.getName(), "create_date") || StringUtils.startsWithIgnoreCase(column.getName(), "update_date")) {
				column.setShowType("dateselect");
			}
			// 备注、内容
			else if (StringUtils.equalsIgnoreCase(column.getName(), "remarks") || StringUtils.equalsIgnoreCase(column.getName(), "content")) {
				column.setShowType("textarea");
			}// 删除标记
			else if (StringUtils.equalsIgnoreCase(column.getName(), "del_flag")) {
				column.setShowType("radiobox");
				column.setDictType("del_flag");
			}
		}
	}

	/**
	 * 获取代码生成配置对象
	 * @return
	 */
	public static GenConfig getConfig() {
		return fileToObject("/frame/gen/genConfig.xml", GenConfig.class);
	}

	/**
	 * XML文件转换为对象
	 * @param fileName
	 * @param clazz
	 * @return
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

		model.put("packageName", StringUtils.lowerCase(genScheme.getPackageName()));
		model.put("lastPackageName", StringUtils.substringAfterLast((String) model.get("packageName"), "."));
		model.put("moduleName", StringUtils.lowerCase(genScheme.getModuleName()));
		// model.put("subModuleName",
		// StringUtils.lowerCase(genScheme.getSubModuleName()));

		model.put("functionName", genScheme.getFunctionName());
		// model.put("functionNameSimple", genScheme.getFunctionNameSimple());
		model.put("functionAuthor", genScheme.getFunctionAuthor());
		// model.put("functionVersion", DateUtils.getDate());
		// model.put("className",
		// StringUtils.uncapitalize(genScheme.getGenSpecial().getpTableName()));
		// model.put("ClassName",
		// StringUtils.capitalize(genScheme.getGenSpecial().getpTableName()));
		// model.put("urlPrefix",model.get("moduleName")+
		// (StringUtils.isNotBlank(genScheme.getSubModuleName()) ? "/" +
		// StringUtils.lowerCase(genScheme.getSubModuleName()) : "") + "/"+
		// model.get("className"));
		model.put("viewPrefix", model.get("urlPrefix"));
		// model.put("permissionPrefix",model.get("moduleName")+
		// (StringUtils.isNotBlank(genScheme.getSubModuleName()) ? ":" +
		// StringUtils.lowerCase(genScheme.getSubModuleName()) : "") + ":"+
		// model.get("className"));
		model.put("dbType", Global.getConfig("jdbc.type"));
		// model.put("table", genScheme.getGenSpecial());
		return null;
	}

	public static void generateToFile(GenTemplate tpl, Map<String, Object> model) {
		String content = FreeMarkers.renderString(StringUtils.trimToEmpty(tpl.getContent()), model);
		System.out.println(content);
	}
	
	public static void main(String[] args) {
		System.out.println(getConfig().getShowTypeList());
	}
}
