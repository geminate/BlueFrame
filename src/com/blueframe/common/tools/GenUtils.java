package com.blueframe.common.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.blueframe.common.mapper.JaxbMapper;
import com.blueframe.frame.gen.model.GenConfig;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.model.GenTableColumn;
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
			return (T) JaxbMapper.fromXml(sb.toString(), clazz);
		} catch (IOException e) {
			logger.warn("读取 代码生成器 配置文件错误，文件路径：" + pathName + ",错误信息：" + e.getMessage());
		}
		return null;
	}
}
