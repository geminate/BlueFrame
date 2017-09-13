package com.blueframe.frame.base.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.base.model.BaseEntity;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.sys.model.SysUser;

public abstract class BaseService<D extends BaseDao<E>, E extends BaseEntity<E>> {

	@Autowired
	protected D dao;

	/**
	 * 增
	 * @param entity
	 */
	public void insert(E entity, Boolean autoAddUUID) {
		entity = preInsert(entity, autoAddUUID);
		dao.insert(entity);
	}

	/**
	 * 删
	 * @param entity
	 */
	public void delete(E entity, Boolean logicDelete) {
		if (logicDelete) {
			dao.deleteLogic(entity);
		} else {
			dao.delete(entity);
		}
	}

	/**
	 * 改
	 * @param entity
	 */
	public void update(E entity) {
		dao.update(entity);
	}

	/**
	 * 查
	 * @param entity
	 * @param like
	 * @return
	 */
	public List<E> select(E entity, Boolean like) {
		if (like) {
			return dao.selectLike(entity);
		} else {
			return dao.select(entity);
		}
	}

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
	 * @param entity
	 * @param like
	 * @return
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
	 * @param entity
	 * @param request
	 * @param page
	 * @return
	 */
	public Page<E> selectPage(E entity, HttpServletRequest request, Page<E> page) {
		entity.setPage(page);
		List<E> list = dao.selectLike(entity);
		page.setData(list);
		return page;
	}

	private E preInsert(E entity, Boolean autoAddUUID) {
		entity.setCreateBy(new SysUser());
		entity.setCreateDate(new Date());
		entity.setUpdateBy(new SysUser());
		entity.setUpdateDate(new Date());
		entity.setDelFlag("0");
		if (autoAddUUID) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			entity.setId(uuid);
		}
		return entity;
	}

}
