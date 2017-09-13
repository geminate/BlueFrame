package com.blueframe.frame.gen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueframe.frame.base.dao.BaseDao;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.model.GenTableColumn;

@Repository
public interface GenTableDao extends BaseDao<GenTable> {

	List<GenTable> findTableListFromDb(GenTable genTable);

	List<GenTableColumn> findTableColumnFromDb(GenTable genTable);

	List<String> findTablePKListFromDb(GenTable genTable);

}
