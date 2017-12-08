package com.blueframe.frame.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.sys.model.SysPermission;
import com.blueframe.frame.sys.service.SysPermissionService;

/**
 * 权限管理
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/sys/sysPermission")
public class SysPermissionController extends BaseController {

	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 权限管理 - 列表页 - GET,POST
	 * @param sysPermission 筛选条件
	 * @return 权限管理列表页
	 */
	@RequestMapping(value = { "", "/list" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView toList(SysPermission sysPermission) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysPermission/list");
		List<SysPermission> sysPermissionList = sysPermissionService.treeSelect(sysPermission, true);
		mov.addObject("sysPermissionList", sysPermissionList);
		return mov;
	}

	/**
	 * 权限管理 - 获取全部菜单 - POST
	 * @return 菜单列表
	 */
	@RequestMapping(value = "/treeAjax", method = RequestMethod.POST)
	public List<SysPermission> toPostTreeAjax() {
		List<SysPermission> sysPermissionList = sysPermissionService.treeSelect(new SysPermission(), true);
		return sysPermissionList;
	}

	/**
	 * 权限管理 - 新增页 - GET
	 * @return 权限管理新增页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert(SysPermission sysPermission) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysPermission/insert");
		if (sysPermission != null && sysPermission.getParent() != null) {
			SysPermission parent = sysPermissionService.selectById(sysPermission.getParent().getId());
			sysPermission.setParent(parent);
		} else {
			SysPermission parent = sysPermissionService.selectById("1");
			sysPermission.setParent(parent);
		}
		mov.addObject("sysPermission", sysPermission);
		return mov;
	}

	/**
	 * 权限管理 - 新增操作 - POST
	 * @param sysPermission 新增的权限对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(SysPermission sysPermission, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysPermission/list");
		sysPermissionService.treeInsert(sysPermission, true);
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}

	/**
	 * 权限管理 - 删除页 - GET
	 * @param sysPermission 要删除的权限
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView toGetDelete(SysPermission sysPermission, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysPermission/list");
		sysPermissionService.deleteById(sysPermission.getId(), true);
		addRedirectToastr(attributes, "success", "", "删除成功！");
		return mov;
	}

	/**
	 * 权限管理 - 更新页 - GET
	 * @param sysPermission 要更新的权限对象
	 * @return 更新页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGeUpdate(SysPermission sysPermission) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysPermission/update");
		mov.addObject("sysPermission", sysPermissionService.selectById(sysPermission.getId()));
		return mov;
	}

	/**
	 * 权限管理 - 更新操作 - POST
	 * @param sysPermission 要更新的权限对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPosUpdate(SysPermission sysPermission, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysPermission/list");
		sysPermissionService.treeUpdate(sysPermission);
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}

}
