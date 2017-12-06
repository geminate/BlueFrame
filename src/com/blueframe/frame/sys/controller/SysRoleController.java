package com.blueframe.frame.sys.controller;

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
import com.blueframe.frame.sys.model.SysPermission;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.service.SysPermissionService;
import com.blueframe.frame.sys.service.SysRolePermissionService;
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

	@Autowired
	private SysPermissionService sysPermissionService;

	@Autowired
	private SysRolePermissionService sysRolePermissionService;

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

	/**
	 * 角色管理 - 新增页 - GET
	 * @return 新增页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysRole/insert");
		return mov;
	}

	/**
	 * 角色管理 - 新增操作 - POST
	 * @param sysRole 新增对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(SysRole sysRole, String sysPermissions, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysRole/list");
		sysRoleService.insert(sysRole, true);
		sysRolePermissionService.bundlePermissionsToRole(sysRole, sysPermissions);
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}

	/**
	 * 角色管理 - 删除操作- POST
	 * @param sysRole 要删除的角色对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ReturnMessage toPostDelete(SysRole sysRole) {
		sysRoleService.deleteById(sysRole.getId(), true);
		sysRolePermissionService.deleteAllPermissionsByRole(sysRole);
		return buildReturnMessage("success", "", "删除成功！");
	}

	/**
	 * 角色管理 - 编辑页 - GET
	 * @param sysRole 要编辑的角色对象
	 * @return 编辑页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGeUpdate(SysRole sysRole) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysRole/update");
		mov.addObject("sysRole", sysRoleService.selectById(sysRole.getId()));
		List<SysPermission> sysPermissionList = sysPermissionService.selectPermissionsByRole(sysRole.getId());
		mov.addObject("sysPermissions", sysPermissionService.entityListToIdsStr(sysPermissionList));
		return mov;
	}

	/**
	 * 角色管理 - 编辑操作 - POST
	 * @param sysRole 要编辑的角色对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPosUpdate(SysRole sysRole, String sysPermissions, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysRole/list");
		sysRoleService.update(sysRole);
		sysRolePermissionService.deleteAllPermissionsByRole(sysRole);
		sysRolePermissionService.bundlePermissionsToRole(sysRole, sysPermissions);
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}

}
