package com.blueframe.frame.common.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射工具类
 * @author hhLiu
 */
public class ReflectionUtil {

	/**
	 * 获取指定Class的实例
	 * @param cls Class
	 * @return 实例
	 */
	public static Object getClassInstance(Class<?> cls) {
		try {
			return cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得对象属性
	 * @param obj 对象
	 * @param fieldName 属性名
	 * @return 属性值
	 */
	public static Object getFieldValue(final Object obj, final String fieldName) {
		Field field = getAccessibleField(obj, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("对象[" + obj + "]中不存在[" + fieldName + "]属性");
		}
		try {
			return field.get(obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 设置对象属性
	 * @param obj 对象
	 * @param fieldName 属性名
	 * @param value 属性值
	 */
	public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
		Field field = getAccessibleField(obj, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("对象[" + obj + "]中不存在[" + fieldName + "]属性");
		}
		try {
			field.set(obj, value);
		} catch (Exception e) {
		}
	}

	/**
	 * 循环向上转型(查找对应属性)
	 * @param obj 对象
	 * @param fieldName 属性名
	 * @return 属性对象
	 */
	public static Field getAccessibleField(final Object obj, final String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				Field field = superClass.getDeclaredField(fieldName);
				makeAccessible(field);
				return field;
			} catch (NoSuchFieldException e) {
				continue;
			}
		}
		return null;
	}

	/**
	 * 获取某个Class的父类的泛型参数的类型
	 * @param cls Class 
	 * @param index 参数索引
	 * @return 泛型参数Class
	 */
	public static Class<?> getClassGenricType(Class<?> cls, int index) {
		Type genType = cls.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class<?>) params[index];
	}

	/**
	 * 将指定属性设置为可访问
	 * @param field 属性对象
	 */
	private static void makeAccessible(Field field) {
		if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier.isFinal(field.getModifiers()))
				&& !field.isAccessible()) {
			field.setAccessible(true);
		}
	}

}
