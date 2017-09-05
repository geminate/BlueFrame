package com.blueframe.frame.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.base.model.BaseEntity;
import com.blueframe.frame.base.model.Page;

public abstract class BaseService<E extends BaseEntity<E>> {

	public abstract BaseDao<E> getDao();

	public void insert(E entity) {
		getDao().insert(entity);
	}

	public void delete(E entity) {
		getDao().delete(entity);
	}

	public void update(E entity) {
		getDao().update(entity);
	}

	public List<E> select(E entity, Boolean like) {
		return getDao().select(entity, like);
	}

	public Integer count(E entity, Boolean like) {
		return getDao().count(entity, like);
	}

	public Page<E> selectPage(E entity, HttpServletRequest request, Page<E> page) {
		entity.setPage(page);
		List<E> list = select(entity, true);
		//Integer count = count(entity, true);
		page.setData(list);
		//page.setRecordsTotal(count);
		//page.setRecordsFiltered(count);
		return page;
	}

}
