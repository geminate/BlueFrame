package com.blueframe.frame.gen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.common.tools.GenUtils;
import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.AjaxInfo;
import com.blueframe.frame.base.model.Page;
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
	 * 业务表配置-列表页-表格数据AJAx
	 * @param genTable
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<GenTable> toPostList(GenTable genTable, HttpServletRequest request) {
		Page<GenTable> page = new Page<GenTable>(request);
		page = genTableService.selectPage(genTable, request, page);
		return page;
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
	 * 业务表配置-业务表列信息添加-GET
	 * @param genTable
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert(GenTable genTable) {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/insert");
		genTable = genTableService.getTableNewInfo(genTable.getName());
		mov.addObject("config", GenUtils.getConfig());
		mov.addObject("genTable", genTable);
		return mov;
	}

	/**
	 * 业务表配置-保存业务表字段信息-POST
	 * @param genTable
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(GenTable genTable) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genTable/list");
		genTableService.insertTableAndColumn(genTable);
		return mov;
	}

	/**
	 * 业务表配置-业务表信息编辑-GET
	 * @param genTable
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGetUpdate(GenTable genTable) {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/update");

		GenTable storageGenTable = genTableService.getTableStorageInfo(genTable.getId());
		GenTable newGenTable = genTableService.getTableNewInfo(storageGenTable.getName());

		genTable = genTableService.mixNewAndStorageColumn(newGenTable, storageGenTable);
		mov.addObject("config", GenUtils.getConfig());
		mov.addObject("genTable", genTable);
		return mov;
	}

	/**
	 * 业务表配置-业务表信息编辑操作-POST
	 * @param genTable
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPostUpdate(GenTable genTable) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genTable/list");
		genTableService.updateTableAndColumn(genTable);
		return mov;
	}

	/**
	 * 业务表配置-业务表删除操作-POST
	 * @param genTable
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxInfo toPostDelete(GenTable genTable) {
		genTableService.delete(genTable, true);
		return new AjaxInfo("success");
	}
}