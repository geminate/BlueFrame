package com.blueframe.frame.base.service;

import java.util.ArrayList;
import java.util.List;

import com.blueframe.frame.base.dao.TreeDao;
import com.blueframe.frame.base.model.TreeEntity;

public abstract class TreeService<D extends TreeDao<E>, E extends TreeEntity<E>> extends BaseService<D, E> {

	public List<E> selectTree(E entity, Boolean like) {
		return selectTree(entity, like, "");
	}

	public List<E> selectTree(E entity, Boolean like, String rootParentId) {
		List<E> sourceList = select(entity, like);
		List<E> reList = new ArrayList<>();
		if (sourceList != null && sourceList.size() > 0) {
			treePreSort(reList, sourceList, rootParentId);
		}
		return reList;
	}

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
}
