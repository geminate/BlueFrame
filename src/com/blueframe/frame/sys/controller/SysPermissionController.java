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
import com.blueframe.frame.sys.model.SysPermission;
import com.blueframe.frame.sys.service.SysPermissionService;

/**
 * 权限管理
 */
@Controller
@RequestMapping(value = "/frame/sys/sysPermission")
public class SysPermissionController extends BaseController {

	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 权限管理-列表页-GET
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysPermission/list");
		return mov;
	}

	/**
	 * 权限管理-列表页-表格数据Ajax-POST
	 * @param sysPermission
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<SysPermission> toPostList(SysPermission sysPermission, HttpServletRequest request) {
		Page<SysPermission> page = new Page<SysPermission>(request);
		page = sysPermissionService.selectPage(sysPermission, request, page);
		return page;
	}

}
