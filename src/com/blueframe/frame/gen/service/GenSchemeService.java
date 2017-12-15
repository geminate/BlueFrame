package com.blueframe.frame.gen.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.BaseService;
import com.blueframe.frame.common.utils.GenUtil;
import com.blueframe.frame.gen.dao.GenSchemeDao;
import com.blueframe.frame.gen.model.GenConfig;
import com.blueframe.frame.gen.model.GenScheme;
import com.blueframe.frame.gen.model.GenTemplate;

@Service
public class GenSchemeService extends BaseService<GenSchemeDao, GenScheme> {

	public void build(GenScheme genScheme) {
		GenConfig config = GenUtil.getConfig();
		List<GenTemplate> templateList = GenUtil.getTemplateList(config, false);
		Map<String, Object> model = GenUtil.getDataModelNew(genScheme);
		for (GenTemplate tpl : templateList) {
			GenUtil.generateToFile(tpl, model);
		}

	}
}
