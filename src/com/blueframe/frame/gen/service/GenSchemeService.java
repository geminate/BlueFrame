package com.blueframe.frame.gen.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.blueframe.common.tools.GenUtils;
import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.gen.dao.GenSchemeDao;
import com.blueframe.frame.gen.model.GenConfig;
import com.blueframe.frame.gen.model.GenScheme;
import com.blueframe.frame.gen.model.GenTemplate;

@Service
public class GenSchemeService extends BaseService<GenSchemeDao, GenScheme> {

	public void build(GenScheme genScheme) {
		GenConfig config = GenUtils.getConfig();
		List<GenTemplate> templateList = GenUtils.getTemplateList(config, false);
		System.out.println(templateList);
		Map<String, Object> model = GenUtils.getDataModelNew(genScheme);
		for (GenTemplate tpl : templateList){
			GenUtils.generateToFile(tpl, model);
		}
	}
}
