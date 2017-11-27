package com.blueframe.frame.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.service.SysRoleService;

/**
 * 角色管理
 */
@Controller
@RequestMapping(value = "/frame/sys/sysRole")
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 角色管理-列表页-GET
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysRole/list");
		return mov;
	}

	/**
	 * 角色管理-列表页-表格数据Ajax-POST
	 * @param sysRole
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<SysRole> toPostList(SysRole sysRole, HttpServletRequest request) {
		Page<SysRole> page = new Page<SysRole>(request);
		page = sysRoleService.selectPage(sysRole, request, page);
		return page;
	}

}
