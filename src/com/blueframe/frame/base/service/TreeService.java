package com.blueframe.frame.base.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blueframe.frame.base.dao.TreeDao;
import com.blueframe.frame.base.model.TreeEntity;

/**
 * 树状 Service 基类
 * @author hhLiu
 */
public abstract class TreeService<D extends TreeDao<E>, E extends TreeEntity<E>> extends BaseService<D, E> {

	@Autowired
	protected D dao;
	
	/**
	 * 树状数据 插入
	 * @param entity 插入对象
	 * @param autoAddUUID 是否自动生成ID
	 */
	public void treeInsert(E entity, boolean autoAddUUID) {
		handleParentIds(entity);
		insert(entity, autoAddUUID);
	}

	/**
	 * 树状数据 批量插入
	 * @param entityList 插入对象列表
	 * @param autoAddUUID 是否自动生成ID
	 */
	public void treeInsertBatch(List<E> entityList, boolean autoAddUUID) {
		for (E entity : entityList) {
			handleParentIds(entity);
		}
		insertBatch(entityList, autoAddUUID);
	}

	/**
	 * 树状数据 批量插入
	 * @param entityList 插入对象列表
	 * @param autoAddUUID 是否自动生成ID
	 */
	public void treeInsertBatch(List<E> entityList, Boolean autoAddUUID) {
		for (E entity : entityList) {
			handleParentIds(entity);
		}
		insertBatch(entityList, autoAddUUID);
	}

	/**
	 * 树状数据 删除
	 * @param entity 删除对象
	 * @param logicDelete 是否是逻辑删除
	 */
	public void treeDelete(E entity, Boolean logicDelete) {
		delete(entity, logicDelete);
	}

	/**
	 * 树状数据 修改
	 * @param entity 修改对象
	 */
	public void treeUpdate(E entity) {
		handleParentIds(entity);
		update(entity);
	}

	/**
	 * 树状数据 查询<br>
	 * 1. 会自动按照树结构顺序进行排序<br>
	 * 2. 会将查询对象的全部父节点一并返回
	 * @param entity 查询对象
	 * @param like 是否是模糊查询
	 * @return 查询结果列表
	 */
	public List<E> treeSelect(E entity, Boolean like) {
		List<E> sourceList = select(entity, like);
		List<E> reList = new ArrayList<>();
		if (sourceList != null && sourceList.size() > 0) {
			sourceList = getParentsAndSelf(sourceList);
			treePreSort(reList, sourceList, "0");
		}
		return reList;
	}

	/**
	 * 获取指定节点的全部父节点列表
	 * @param entity 查询对象 (parentIds 属性须有值)
	 * @return 父节点列表
	 */
	public List<E> getParents(E entity) {
		List<E> list = new ArrayList<>();
		list.add(entity);
		return getParents(list);
	}

	/**
	 * 获取指定节点列表的全部父节点列表
	 * @param sourceList 查询对象列表 (parentIds 属性须有值)
	 * @return 父节点列表
	 */
	public List<E> getParents(List<E> sourceList) {
		if (sourceList == null || sourceList.size() <= 0) {
			return new ArrayList<>();
		}
		HashSet<String> hashSet = new HashSet<>();
		for (E entityItem : sourceList) {
			String[] parentIdsStrings = entityItem.getParentIds().split(",");
			if (parentIdsStrings != null && parentIdsStrings.length > 0) {
				for (String parentId : parentIdsStrings) {
					if (parentId != "") {
						hashSet.add(parentId);
					}
				}
			}
		}
		List<String> idsList = new ArrayList<>(hashSet);
		return selectBatch(idsList);
	}

	/**
	 * 获取指定节点的全部父节点和自身组成的列表
	 * @param entity 查询对象 (parentIds 属性须有值)
	 * @return 父节点和自身组成的列表
	 */
	public List<E> getParentsAndSelf(E entity) {
		List<E> list = new ArrayList<>();
		list.add(entity);
		return getParentsAndSelf(list);
	}

	/**
	 * 获取指定节点列表的全部父节点和自身列表组成的列表
	 * @param sourceList 查询对象列表 (parentIds 属性须有值)
	 * @return 父节点和自身列表组成的列表
	 */
	public List<E> getParentsAndSelf(List<E> sourceList) {
		if (sourceList == null || sourceList.size() <= 0) {
			return new ArrayList<>();
		}
		HashSet<String> hashSet = new HashSet<>();
		for (E entityItem : sourceList) {
			hashSet.add(entityItem.getId());
			String[] parentIdsStrings = entityItem.getParentIds().split(",");
			if (parentIdsStrings != null && parentIdsStrings.length > 0) {
				for (String parentId : parentIdsStrings) {
					if (parentId != "") {
						hashSet.add(parentId);
					}
				}
			}
		}
		List<String> idsList = new ArrayList<>(hashSet);
		return selectBatch(idsList);
	}

	/**
	 * 将列表按照树顺序进行排序<br>
	 * 未挂在根节点上的节点将被排除
	 * @param reList 目标列表
	 * @param sourceList 数据源列表
	 * @param parentId 根节点的parentID
	 */
	public void treePreSort(List<E> reList, List<E> sourceList, String parentId) {
		for (int i = 0; i < sourceList.size(); i++) {
			E e = sourceList.get(i);
			if (e.getParent() != null && e.getParent().getId() != null && e.getParent().getId().equals(parentId)) {
				reList.add(e);
				for (int j = 0; j < sourceList.size(); j++) {
					E child = sourceList.get(j);
					if (child.getParent() != null && child.getParent().getId() != null && child.getParent().getId().equals(e.getId())) {
						treePreSort(reList, sourceList, e.getId());
						break;
					}
				}
			}
		}
	}

	/**
	 * 根据对象的 parentId 属性 设置其 的 parentIds 属性
	 * @param entity 操作对象
	 */
	private void handleParentIds(E entity) {
		if (entity.getParent() != null && entity.getParent().getId() != null && entity.getParent().getId() != "") {
			E parent = selectOne(entity.getParent(), false);
			entity.setParentIds(parent.getParentIds() + parent.getId() + ",");
		}
	}

}
