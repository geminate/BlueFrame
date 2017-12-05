package com.blueframe.frame.gen.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.common.tools.StringUtils;
import com.blueframe.frame.common.utils.GenUtil;
import com.blueframe.frame.gen.dao.GenTableDao;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.model.GenTableColumn;

@Service
public class GenTableService extends BaseService<GenTableDao, GenTable> {

	@Autowired
	private GenTableColumnService genTableColumnService;

	public List<GenTable> findTableListFromDb(GenTable genTable) {
		return dao.findTableListFromDb(genTable);
	}

	public GenTable mixNewAndStorageColumn(GenTable newGenTable, GenTable storageGenTable) {

		// 添加新列
		for (GenTableColumn newColumn : newGenTable.getTableColumns()) {
			boolean flag = false;
			for (GenTableColumn storageColumn : storageGenTable.getTableColumns()) {
				if (newColumn.getName().equals(storageColumn.getName())) {
					flag = true;
				}
			}
			if (!flag) {
				storageGenTable.getTableColumns().add(newColumn);
			}
		}

		// 删除已删除的列
		for (GenTableColumn storageColumn : storageGenTable.getTableColumns()) {
			boolean flag = false;
			for (GenTableColumn newColumn : newGenTable.getTableColumns()) {
				if (newColumn.getName().equals(storageColumn.getName())) {
					flag = true;
				}
			}
			if (!flag) {
				storageGenTable.setDelFlag("1");
			}
		}
		return storageGenTable;
	}

	/**
	 * 获取 表 的 最新 信息
	 * @param tableName 表名
	 * @return 表对象
	 */
	public GenTable getTableNewInfo(String tableName) {

		GenTable genTable = new GenTable();
		genTable.setName(tableName);

		List<GenTable> tableList = dao.findTableListFromDb(genTable);
		if (tableList != null && tableList.size() > 0) {
			genTable = tableList.get(0);
			if (StringUtils.isBlank(genTable.getComments())) {
				genTable.setComments(genTable.getName());
			}
			genTable.setClassName(StringUtils.toCapitalizeCamelCase(genTable.getName()));
		}
		genTable = getTableNewColumn(genTable);
		return genTable;
	}

	/**
	 * 获取 表 的 最新 列信息
	 * @param genTable 表对象
	 * @return 表对象
	 */
	public GenTable getTableNewColumn(GenTable genTable) {
		List<GenTableColumn> tableColumns = dao.findTableColumnFromDb(genTable);
		genTable.setTableColumns(tableColumns);
		genTable.setPkList(dao.findTablePKListFromDb(genTable));
		GenUtil.initColumnField(genTable);
		return genTable;
	}

	/**
	 * 获取 表 的 存储 信息
	 * @param id 表ID
	 * @return 表对象
	 */
	public GenTable getTableStorageInfo(String id) {
		GenTable genTable = new GenTable(id);
		genTable = selectOne(genTable, false);
		genTable = getTableStorageColumn(genTable);

		// 排序
		Collections.sort(genTable.getTableColumns(), new Comparator<GenTableColumn>() {

			@Override
			public int compare(GenTableColumn o1, GenTableColumn o2) {
				return o1.getSort() - o2.getSort();
			}
		});

		return genTable;
	}

	public GenTable getTableStorageColumn(GenTable genTable) {
		genTable = selectOne(new GenTable(genTable.getId()), false);
		GenTableColumn genTableColumn = new GenTableColumn();
		genTableColumn.setGenTable(new GenTable(genTable.getId()));
		genTable.setTableColumns((genTableColumnService.select(genTableColumn, false)));
		return genTable;
	}

	public void insertTableAndColumn(GenTable genTable) {
		insert(genTable, true);
		List<GenTableColumn> columns = genTable.getTableColumns();
		for (GenTableColumn genTableColumn : columns) {
			genTableColumn.setGenTable(genTable);
			genTableColumnService.insert(genTableColumn, true);
		}
	}

	public void updateTableAndColumn(GenTable genTable) {
		update(genTable);
		List<GenTableColumn> columns = genTable.getTableColumns();
		for (GenTableColumn genTableColumn : columns) {
			genTableColumn.setGenTable(genTable);
			genTableColumnService.update(genTableColumn);
		}
	}
}
