package com.blueframe.frame.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.common.tools.StringUtils;
import com.blueframe.frame.common.utils.GenUtil;
import com.blueframe.frame.gen.model.GenTemplate;
import com.blueframe.frame.sys.dao.SysDictDao;
import com.blueframe.frame.sys.model.SysDict;

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

	public void genEnum(List<SysDict> sysDicts, String path) {
		GenTemplate template = GenUtil.fileToObject("frame/gen/eu/enum.xml", GenTemplate.class);
		Map<String, List<SysDict>> map = new HashMap<>();
		for (SysDict sysDict : sysDicts) {
			if (map.get(sysDict.getType()) != null) {
				map.get(sysDict.getType()).add(sysDict);
			} else {
				List<SysDict> dicts = new ArrayList<>();
				dicts.add(sysDict);
				map.put(sysDict.getType(), dicts);
			}
		}
		for (Entry<String, List<SysDict>> entry : map.entrySet()) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("packagePath", path);
			model.put("ClassName", StringUtils.toCapitalizeCamelCase(entry.getKey()));
			model.put("sysDicts", entry.getValue());
			GenUtil.generateToFile(template, model);
		}
	}
}