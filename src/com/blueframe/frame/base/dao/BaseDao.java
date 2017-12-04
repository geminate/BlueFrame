package com.blueframe.frame.base.dao;

import java.util.List;

/**
 * Dao 基类
 * @author hhLiu
 */
public interface BaseDao<E> {

	/**
	 * 插入
	 * @param entity 插入对象
	 */
	public void insert(E entity);

	/**
	 * 批量插入
	 * @param entityList 批量插入对象
	 */
	public void insertBatch(List<E> entityList);

	/**
	 * 物理删除
	 * @param entity 删除对象
	 */
	public void delete(E entity);

	/**
	 * 物理删除
	 * @param id 删除对象ID
	 */
	public void deleteById(String id);

	/**
	 * 批量物理删除
	 * @param ids 删除对象ID列表
	 */
	public void deleteBatch(List<String> ids);

	/**
	 * 逻辑删除
	 * @param entity 删除对象
	 */
	public void deleteLogic(E entity);

	/**
	 * 逻辑删除
	 * @param id 逻辑删除ID
	 */
	public void deleteLogicById(String id);

	/**
	 * 批量逻辑删除
	 * @param ids 逻辑删除对象ID列表
	 */
	public void deleteLogicBatch(List<String> ids);

	/**
	 * 修改
	 * @param entity 修改对象
	 */
	public void update(E entity);

	/**
	 * 查找-精确
	 * @param entity 筛选对象
	 * @return 查询结果列表
	 */
	public List<E> select(E entity);

	/**
	 * 查找-精确
	 * @param id 查找对象ID
	 * @return 查询结果对象
	 */
	public E selectById(String id);

	/**
	 * 查找-模糊
	 * @param entity 筛选对象
	 * @return 查询结果列表
	 */
	public List<E> selectLike(E entity);

	/**
	 * 批量查询
	 * @param ids 要查询的ID列表
	 * @return 批量查询结果列表
	 */
	public List<E> selectBatch(List<String> ids);

	/**
	 * 查询数量-精确
	 * @param entity 筛选对象
	 * @return 查询结果数量
	 */
	public Integer count(E entity);

	/**
	 * 查询数量-模糊
	 * @param entity 筛选对象
	 * @return 查询结果数量
	 */
	public Integer countLike(E entity);

}
