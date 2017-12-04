package com.blueframe.frame.base.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.base.model.BaseEntity;
import com.blueframe.frame.base.model.Page;

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
		List<E> list = new ArrayList<>();
		if (like) {
			list = dao.selectLike(entity);
		} else {
			list = dao.select(entity);
		}

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
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
	 * 批量查询
	 * @param ids 要查询的ID列表
	 * @return 查询结果列表
	 */
	public List<E> selectBatch(List<String> ids) {
		return dao.selectBatch(ids);
	}
}
