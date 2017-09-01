package com.blueframe.modules.sys.service;

import java.util.List;

import com.blueframe.modules.sys.dao.BaseDao;

public abstract class BaseService<E> {

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

	public List<E> select(E entity) {
		return getDao().select(entity);
	}

	public Long count(E entity) {
		return getDao().count(entity);
	}
}
