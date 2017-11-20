package com.blueframe.frame.base.dao;

import java.util.List;

public interface BaseDao<E> {

	/**
	 * 增
	 * @param entity
	 */
	public void insert(E entity);

	/**
	 * 批量增加
	 * @param entityList
	 */
	public void insertBatch(List<E> entityList);

	/**
	 * 删
	 * @param entity
	 */
	public void delete(E entity);

	public void deleteLogic(E entity);

	/**
	 * 改
	 * @param entity
	 */
	public void update(E entity);

	/**
	 * 查-精确
	 * @param entity
	 * @return
	 */
	public List<E> select(E entity);

	/**
	 * 查-模糊
	 * @param entity
	 * @return
	 */
	public List<E> selectLike(E entity);

	/**
	 * 查询数量-精确
	 * @param entity
	 * @return
	 */
	public Integer count(E entity);

	/**
	 * 查询数量-模糊
	 * @param entity
	 * @return
	 */
	public Integer countLike(E entity);

}
