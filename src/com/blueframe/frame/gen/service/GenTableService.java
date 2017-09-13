package com.blueframe.frame.gen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.common.tools.GenUtils;
import com.blueframe.common.tools.StringUtils;
import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.gen.dao.GenTableDao;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.model.GenTableColumn;

@Service
public class GenTableService extends BaseService<GenTableDao, GenTable> {

	public List<GenTable> findTableListFromDb(GenTable genTable) {
		return dao.findTableListFromDb(genTable);
	}

	public GenTable findTableColumnFromDb(GenTable genTable) {
		if (StringUtils.isNotBlank(genTable.getName())) {
			List<GenTable> tableList = dao.findTableListFromDb(genTable);
			if (tableList != null && tableList.size() > 0) {
				genTable = tableList.get(0);
			}

			List<GenTableColumn> tableColumns = dao.findTableColumnFromDb(genTable);
			genTable.setTableColumns(tableColumns);

			// 获取表的 主键List
			genTable.setPkList(dao.findTablePKListFromDb(genTable));

			// 初始化列信息
			GenUtils.initColumnField(genTable);
		}
		
		return genTable;
	}
}
