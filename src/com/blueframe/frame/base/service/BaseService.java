package com.blueframe.frame.base.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.base.model.BaseEntity;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.common.tools.ReflectionUtil;

/**
 * Service 基类
 * @author hhLiu
 */
public abstract class BaseService<D extends BaseDao<E>, E extends BaseEntity<E>> {

	@Autowired
	protected D dao;

	/**
	 * 插入
	 * @param entity 插入对象
	 * @param autoAddUUID 是否自动生成ID
	 */
	public void insert(E entity, Boolean autoAddUUID) {
		entity.preInsert(autoAddUUID);
		dao.insert(entity);
	}

	/**
	 * 批量插入
	 * @param entityList 插入对象列表
	 * @param autoAddUUID 是否自动生成ID
	 */
	public void insertBatch(List<E> entityList, Boolean autoAddUUID) {
		for (E entity : entityList) {
			entity.preInsert(autoAddUUID);
		}
		dao.insertBatch(entityList);
	}

	/**
	 * 删除
	 * @param entity 删除对象
	 * @param logicDelete 是否是逻辑删除
	 */
	public void delete(E entity, Boolean logicDelete) {
		if (logicDelete) {
			dao.deleteLogic(entity);
		} else {
			dao.delete(entity);
		}
	}

	/**
	 * 根据ID 删除
	 * @param id 删除对象的 ID
	 * @param logicDelete 是否是逻辑删除
	 */
	@SuppressWarnings("unchecked")
	public void deleteById(String id, Boolean logicDelete) {
		Class<?> cls = ReflectionUtil.getClassGenricType(getClass(), 1);
		E entity = (E) ReflectionUtil.getClassInstance(cls);
		ReflectionUtil.setFieldValue(entity, "id", id);
		if (logicDelete) {
			dao.deleteLogic(entity);
		} else {
			dao.delete(entity);
		}
	}

	/**
	 * 批量删除
	 * @param ids 删除对象的ID列表
	 * @param logicDelete 是否是逻辑删除
	 */
	public void deleteBatch(List<String> ids, Boolean logicDelete) {
		if (logicDelete) {
			dao.deleteLogicBatch(ids);
		} else {
			dao.deleteBatch(ids);
		}
	}

	public void deleteBatchE(List<E> ids, Boolean logicDelete) {
		List<String> idList = new ArrayList<>();
		for (E e : ids) {
			idList.add(e.getId());
		}
		deleteBatch(idList, logicDelete);
	}

	/**
	 * 修改
	 * @param entity 修改对象
	 */
	public void update(E entity) {
		entity.preUpdate();
		dao.update(entity);
	}

	/**
	 * 查找
	 * @param entity 筛选对象
	 * @param like 是否是模糊查询
	 * @return 查询结果列表
	 */
	public List<E> select(E entity, Boolean like) {
		if (like) {
			return dao.selectLike(entity);
		} else {
			return dao.select(entity);
		}
	}

	/**
	 * 查找单条数据
	 * @param entity 筛选对象
	 * @param like 是否是模糊查询
	 * @return 查询结果
	 */
	public E selectOne(E entity, Boolean like) {
		List<E> list = select(entity, like);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 根据ID查找单条数据
	 * @param id 对象ID
	 * @return 查询结果对象
	 */
	@SuppressWarnings("unchecked")
	public E selectById(String id) {
		Class<?> cls = ReflectionUtil.getClassGenricType(getClass(), 1);
		E entity = (E) ReflectionUtil.getClassInstance(cls);
		ReflectionUtil.setFieldValue(entity, "id", id);
		return selectOne(entity, false);
	}

	/**
	 * 批量查询
	 * @param ids 要查询的ID列表
	 * @return 查询结果列表
	 */
	public List<E> selectBatch(List<String> ids) {
		return dao.selectBatch(ids);
	}

	/**
	 * 查询数量
	 * @param entity 筛选对象
	 * @param like 是否是模糊查询
	 * @return 查询结果数量
	 */
	public Integer count(E entity, Boolean like) {
		if (like) {
			return dao.countLike(entity);
		} else {
			return dao.count(entity);
		}
	}

	/**
	 * 分页查询
	 * @param entity 筛选对象
	 * @param request 请求对象
	 * @param page 分页参数对象
	 * @return 带分页的查询结果
	 */
	public Page<E> selectPage(E entity, HttpServletRequest request, Page<E> page) {
		entity.setPage(page);
		List<E> list = dao.selectLike(entity);
		page.setData(list);
		return page;
	}

	/**
	 * 将对象List 转换成 用逗号分隔的ID字符串：1,2,3
	 * @param entityList 对象List
	 * @return 用逗号分隔的ID字符串
	 */
	public String entityListToIdsStr(List<E> entityList) {
		StringBuffer reBuffer = new StringBuffer("");
		if (entityList != null && !entityList.isEmpty()) {
			for (int i = 0; i < entityList.size(); i++) {
				reBuffer.append(entityList.get(i).getId());
				if (i < entityList.size() - 1) {
					reBuffer.append(",");
				}
			}
		}
		return reBuffer.toString();
	}

	/**
	 * 检查 是否重复
	 * @param cls 对象类
	 * @param propName 属性名
	 * @param value 属性值
	 * @return 是否重复
	 */
	@SuppressWarnings("unchecked")
	public boolean checkIsExist(Class<?> cls, String propName, String value) {
		E entity = (E) ReflectionUtil.getClassInstance(cls);
		ReflectionUtil.setFieldValue(entity, propName, value);
		if (count(entity, false) > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查 是否重复 使用第二个泛型参数作为Class
	 * @param propName 属性名
	 * @param value 属性值
	 * @return 是否重复
	 */
	@SuppressWarnings("unchecked")
	public boolean checkIsExist(String propName, String value) {
		Class<?> cls = ReflectionUtil.getClassGenricType(getClass(), 1);
		E entity = (E) ReflectionUtil.getClassInstance(cls);
		ReflectionUtil.setFieldValue(entity, propName, value);
		if (count(entity, false) > 0) {
			return true;
		} else {
			return false;
		}
	}
}