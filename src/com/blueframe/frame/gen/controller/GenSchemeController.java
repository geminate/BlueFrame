package com.blueframe.frame.gen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.base.model.ReturnMessage;
import com.blueframe.frame.gen.model.GenScheme;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.service.GenSchemeService;
import com.blueframe.frame.gen.service.GenTableService;

/**
 * 代码生成器-生成方案配置 Controller
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/gen/genScheme")
public class GenSchemeController extends BaseController {

	@Autowired
	private GenSchemeService genSchemeService;

	@Autowired
	private GenTableService genTableService;

	/**
	 * 生成方案配置 - 列表页 - GET
	 * @return 列表页
	 */
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/gen/genScheme/list");
		return mov;
	}

	/**
	 * 生成方案配置 - 列表页表格数据Ajax - POST
	 * @param genScheme 筛选对象
	 * @param request 请求对象
	 * @return 带分页的查询结果列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<GenScheme> toPostList(GenScheme genScheme, HttpServletRequest request) {
		Page<GenScheme> page = new Page<GenScheme>(request);
		page = genSchemeService.selectPage(genScheme, request, page);
		return page;
	}

	/**
	 * 生成方案配置 - 新增页 - GET
	 * @return 新增页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert() {
		ModelAndView mov = new ModelAndView("/frame/gen/genScheme/insert");
		List<GenTable> genTables = genTableService.select(new GenTable(), false);
		mov.addObject("genTables", genTables);
		return mov;
	}

	/**
	 * 生成方案配置 - 新增操作 - POST
	 * @param genScheme 新增对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(GenScheme genScheme, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genScheme/list");
		genSchemeService.insert(genScheme, true);
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}

	/**
	 * 生成方案配置 - 删除操作 - POST
	 * @param genScheme 删除对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ReturnMessage toPostDelete(GenScheme genScheme) {
		genSchemeService.deleteById(genScheme.getId(), true);
		return buildReturnMessage("success", "", "删除成功！");
	}

	/**
	 * 生成方案配置 - 编辑页 - GET
	 * @param genScheme 要编辑的方案对象
	 * @return 编辑页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGetUpdate(GenScheme genScheme) {
		ModelAndView mov = new ModelAndView("/frame/gen/genScheme/update");
		mov.addObject("genScheme", genSchemeService.selectById(genScheme.getId()));
		mov.addObject("genTables", genTableService.select(new GenTable(), false));
		return mov;
	}

	/**
	 * 生成方案配置 - 编辑操作 - POST
	 * @param genScheme 要编辑的方案对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPostUpdate(GenScheme genScheme, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genScheme/list");
		genSchemeService.update(genScheme);
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}

	/**
	 * 生成方案配置 - 生成操作 - POST
	 * @param genScheme 要生成的方案对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/build")
	public ModelAndView toBuild(GenScheme genScheme, RedirectAttributes attributes) {
		genSchemeService.build(genSchemeService.selectById(genScheme.getId()));
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genScheme/list");
		addRedirectToastr(attributes, "success", "", "生成成功！");
		return mov;
	}
}
