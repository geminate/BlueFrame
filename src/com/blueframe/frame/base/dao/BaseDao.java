package com.blueframe.frame.base.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public abstract class BaseDao<E> extends SqlSessionDaoSupport {

	public abstract Class<?> getEntityClass();

	/**
	 * 增
	 * @param entity
	 */
	public void insert(E entity) {
		getSqlSession().insert(getEntityClass().getSimpleName() + ".insert", entity);
	}

	/**
	 * 删
	 * @param entity
	 */
	public void delete(E entity) {
		getSqlSession().delete(getEntityClass().getSimpleName() + ".delete", entity);
	}

	/**
	 * 改
	 * @param entity
	 */
	public void update(E entity) {
		getSqlSession().update(getEntityClass().getSimpleName() + ".update", entity);
	}

	/**
	* 查
	* @param entity
	* @return
	*/
	public List<E> select(E entity, Boolean like) {
		if (like) {
			List<E> list = getSqlSession().selectList(getEntityClass().getSimpleName() + ".selectLike", entity);
			return list;
		} else {
			List<E> list = getSqlSession().selectList(getEntityClass().getSimpleName() + ".select", entity);
			return list;
		}
	}

	/**
	 * 获取查询数量
	 * @return
	 */
	public Integer count(E entity, Boolean like) {
		if (like) {
			return getSqlSession().selectOne(getEntityClass().getSimpleName() + ".countLike", entity);
		} else {
			return getSqlSession().selectOne(getEntityClass().getSimpleName() + ".count", entity);
		}
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}
