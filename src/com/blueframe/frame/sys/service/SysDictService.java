package com.blueframe.frame.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blueframe.frame.sys.dao.SysDictDao;
import com.blueframe.frame.sys.model.SysDict;
import com.blueframe.frame.base.service.BaseService;

/**
 * 字典项管理 Service
 * @author hhLiu
 */
@Service
public class SysDictService extends BaseService<SysDictDao, SysDict> {

	/**
	 * 获取全部 字典项类型
	 * @return 全部 字典项类型列表
	 */
	public List<String> selectAllTypeList() {
		return dao.selectAllTypeList();
	}

}