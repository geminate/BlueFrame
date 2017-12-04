package com.blueframe.frame.common.utils;

import java.io.StringReader;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;

import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.util.Assert;

@SuppressWarnings("rawtypes")
public class JaxbUtil {

	private static ConcurrentMap<Class, JAXBContext> jaxbContexts = new ConcurrentHashMap<Class, JAXBContext>();

	/**
	 * 将 XML 转换成 对象
	 * @param xml XML 字符串
	 * @param clazz 对象类
	 * @param <T> T
	 * @return 转换后对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fromXml(String xml, Class<T> clazz) {
		try {
			StringReader reader = new StringReader(xml);
			T t = (T) createUnmarshaller(clazz).unmarshal(reader);
			return t;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 创建UnMarshaller. 线程不安全，需要每次创建或pooling。
	 * @param clazz 对象类
	 * @return Unmarshaller
	 */
	public static Unmarshaller createUnmarshaller(Class clazz) {
		try {
			JAXBContext jaxbContext = getJaxbContext(clazz);
			return jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected static JAXBContext getJaxbContext(Class clazz) {
		Assert.notNull(clazz, "'clazz' must not be null");
		JAXBContext jaxbContext = jaxbContexts.get(clazz);
		if (jaxbContext == null) {
			try {
				jaxbContext = JAXBContext.newInstance(clazz, CollectionWrapper.class);
				jaxbContexts.putIfAbsent(clazz, jaxbContext);
			} catch (JAXBException ex) {
				throw new HttpMessageConversionException("Could not instantiate JAXBContext for class [" + clazz + "]: " + ex.getMessage(), ex);
			}
		}
		System.out.println(jaxbContext);
		return jaxbContext;
	}

	/**
	 * 封装Root Element 是 Collection的情况.
	 * @author hhLiu
	 */
	public static class CollectionWrapper {

		@XmlAnyElement
		protected Collection<?> collection;
	}
}
