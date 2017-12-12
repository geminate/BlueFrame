package com.blueframe.frame.gen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.base.model.ReturnMessage;
import com.blueframe.frame.common.utils.GenUtil;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.service.GenTableService;

/**
 * 代码生成器-业务表 Controller
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/gen/genTable")
public class GenTableController extends BaseController {

	@Autowired
	private GenTableService genTableService;

	/**
	 * 业务表配置 - 列表页 - GET
	 * @return 列表页
	 */
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/list");
		return mov;
	}

	/**
	 * 业务表配置 - 列表页表格数据Ajax - POST
	 * @param genTable 筛选对象
	 * @param request 请求对象
	 * @return 带分页的查询结果列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<GenTable> toPostList(GenTable genTable, HttpServletRequest request) {
		Page<GenTable> page = new Page<GenTable>(request);
		page = genTableService.selectPage(genTable, request, page);
		return page;
	}

	/**
	 * 业务表配置 - 选择业务表页面 - GET
	 * @return 选择业务表页面
	 */
	@RequestMapping(value = "/selectTable", method = RequestMethod.GET)
	public ModelAndView toGetSelectTable() {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/selectTable");
		List<GenTable> tableList = genTableService.findTableListFromDb(new GenTable());
		mov.addObject("tableList", tableList);
		return mov;
	}

	/**
	 * 业务表配置 - 添加业务表页面 - GET
	 * @param genTable 新增对象
	 * @return 添加页面
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert(GenTable genTable) {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/insert");
		genTable = genTableService.getTableNewInfo(genTable.getName());
		mov.addObject("config", GenUtil.getConfig());
		mov.addObject("genTable", genTable);
		return mov;
	}

	/**
	 * 业务表配置 - 添加业务表操作 - POST
	 * @param genTable 新增对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(GenTable genTable, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genTable/list");
		genTableService.insertTableAndColumn(genTable);
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}

	/**
	 * 业务表配置 - 删除操作 - POST
	 * @param genTable 删除对象
	 * @param attributes 重定向对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ReturnMessage toPostDelete(GenTable genTable, RedirectAttributes attributes) {
		genTableService.delete(genTable, true);
		return buildReturnMessage("success", "", "删除成功！");
	}

	/**
	 * 业务表配置 - 编辑页面 - GET
	 * @param genTable 编辑对象
	 * @return 编辑页面
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGetUpdate(GenTable genTable) {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/update");
		GenTable storageGenTable = genTableService.getTableStorageInfo(genTable.getId());
		GenTable newGenTable = genTableService.getTableNewInfo(storageGenTable.getName());
		genTable = genTableService.mixNewAndStorageColumn(newGenTable, storageGenTable);
		mov.addObject("config", GenUtil.getConfig());
		mov.addObject("genTable", genTable);
		return mov;
	}

	/**
	 * 业务表配置 - 编辑操作 - POST
	 * @param genTable 编辑对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPostUpdate(GenTable genTable, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genTable/list");
		genTableService.updateTableAndColumn(genTable);
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}

}