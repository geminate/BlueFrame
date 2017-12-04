package com.blueframe.frame.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.service.SysRoleService;

/**
 * 角色管理
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/sys/sysRole")
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 角色管理 - 列表页 - GET
	 * @return 列表页
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysRole/list");
		return mov;
	}

	/**
	 * 角色管理 - 列表页表格数据Ajax - POST
	 * @param sysRole 筛选对象
	 * @param request 请求对象
	 * @return 带分页的查询结果列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<SysRole> toPostList(SysRole sysRole, HttpServletRequest request) {
		Page<SysRole> page = new Page<SysRole>(request);
		page = sysRoleService.selectPage(sysRole, request, page);
		return page;
	}

}
