package com.blueframe.frame.common.pagination.interceptor;

import java.io.Serializable;
import java.util.Properties;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;

import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.common.config.Global;
import com.blueframe.frame.common.pagination.dialect.Dialect;
import com.blueframe.frame.common.pagination.dialect.MySQLDialect;
import com.blueframe.frame.common.pagination.dialect.OracleDialect;
import com.blueframe.frame.common.utils.ReflectionUtil;

/**
 * Mybatis 分页拦截器
 * @author hhLiu
 */
public abstract class BaseInterceptor implements Interceptor, Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String PAGE = "page";

	protected Log log = LogFactory.getLog(this.getClass());

	protected Dialect DIALECT;

	/**
	 * 将参数对象 转换成 Page 对象 如果参数对象本身为Page对象 则直接返回，否则获取 参数对象中的 page 属性并将其返回
	 * @param parameterObject 参数对象
	 * @param page 分页对象
	 * @return 分页对象
	 */
	@SuppressWarnings("unchecked")
	protected static Page<Object> convertParameter(Object parameterObject, Page<Object> page) {
		try {
			if (parameterObject instanceof Page) {
				return (Page<Object>) parameterObject;
			} else {
				return (Page<Object>) ReflectionUtil.getFieldValue(parameterObject, PAGE);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 设置属性，支持自定义方言类和制定数据库的方式 <code>dialectClass</code>,自定义方言类。可以不配置这项
	 * <code>dbms</code> 数据库类型，插件支持的数据库 <code>sqlPattern</code> 需要拦截的SQL ID
	 * @param p 属性
	 */
	protected void initProperties(Properties p) {
		Dialect dialect = null;
		String dbType = Global.getConfig("db.type");
		if ("mysql".equals(dbType)) {
			dialect = new MySQLDialect();
		} else if ("oracle".equals(dbType)) {
			dialect = new OracleDialect();
		}
		if (dialect == null) {
			throw new RuntimeException("mybatis dialect error.");
		}
		DIALECT = dialect;

	}
}
