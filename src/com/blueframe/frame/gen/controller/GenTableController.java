package com.blueframe.frame.gen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.common.tools.GenUtils;
import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.service.GenTableService;

/**
 * 代码生成器-业务表 Controller
 */
@Controller
@RequestMapping(value = "/frame/gen/genTable")
public class GenTableController extends BaseController {

	@Autowired
	private GenTableService genTableService;

	/**
	 * 业务表配置-列表页-GET
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/list");
		return mov;
	}

	/**
	 * 业务表配置-添加业务表-GET
	 * @return
	 */
	@RequestMapping(value = "/selectTable", method = RequestMethod.GET)
	public ModelAndView toGetSelectTable() {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/selectTable");
		List<GenTable> tableList = genTableService.findTableListFromDb(new GenTable());
		mov.addObject("tableList", tableList);
		return mov;
	}

	/**
	 * 业务表配置-业务表列信息编辑-GET
	 * @param genTable
	 * @return
	 */
	@RequestMapping(value = "/selectTableColumn", method = RequestMethod.GET)
	public ModelAndView toGetSelectTableColumn(GenTable genTable) {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/selectTableColumn");
		genTable = genTableService.findTableColumnFromDb(genTable);
		mov.addObject("config", GenUtils.getConfig());
		System.out.println(GenUtils.getConfig().getJavaTypeList());
		mov.addObject("genTable", genTable);
		return mov;
	}
}