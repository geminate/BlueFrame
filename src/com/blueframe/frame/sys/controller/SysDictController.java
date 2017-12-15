package com.blueframe.frame.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blueframe.frame.sys.model.SysDict;
import com.blueframe.frame.sys.service.SysDictService;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.base.model.ReturnMessage;

/**
 * 字典项管理 Controller
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/sys/sysDict")
public class SysDictController extends BaseController {

	@Autowired
	private SysDictService sysDictService;

	/**
	 * 字典项管理 - 列表页 - GET
	 * @return 列表页
	 */
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysDict/list");
		mov.addObject("allTypeList", sysDictService.selectAllTypeList());
		return mov;
	}

	/**
	 * 字典项管理 - 列表页表格数据Ajax - POST
	 * @param sysDict 筛选对象
	 * @param request 请求对象
	 * @return 带分页的查询结果列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<SysDict> postList(SysDict sysDict, HttpServletRequest request) {
		Page<SysDict> page = new Page<SysDict>(request);
		page = sysDictService.selectPage(sysDict, request, page);
		return page;
	}

	/**
	 * 字典项管理 - 新增页 - GET
	 * @return 新增页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView getInsert() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysDict/insert");
		return mov;
	}

	/**
	 * 字典项管理 - 新增操作 - POST
	 * @param sysDict 新增对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView postInsert(SysDict sysDict, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysDict/list");
		sysDictService.insert(sysDict, true);
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}

	/**
	 * 字典项管理 - 删除操作- POST
	 * @param sysDict 删除对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ReturnMessage postDelete(SysDict sysDict) {
		sysDictService.deleteById(sysDict.getId(), true);
		return buildReturnMessage("success", "", "删除成功！");
	}

	/**
	 * 字典项管理 - 编辑页 - GET
	 * @param sysDict 编辑对象
	 * @return 编辑页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView getUpdate(SysDict sysDict) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysDict/update");
		mov.addObject("sysDict", sysDictService.selectById(sysDict.getId()));
		return mov;
	}

	/**
	 * 字典项管理 - 编辑操作 - POST
	 * @param sysDict 要编辑的用户对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView postUpdate(SysDict sysDict, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysDict/list");
		sysDictService.update(sysDict);
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}
}