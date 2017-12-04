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
import com.blueframe.frame.common.component.shiro.SecCredentialsMatcher;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysRoleList;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysRoleService;
import com.blueframe.frame.sys.service.SysUserRoleService;
import com.blueframe.frame.sys.service.SysUserService;

/**
 * 用户管理
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/sys/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	/**
	 * 用户管理 - 列表页 - GET
	 * @return 列表页
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/list");
		return mov;
	}

	/**
	 * 用户管理 - 列表页表格数据Ajax - POST
	 * @param sysUser 筛选对象
	 * @param request 请求对象
	 * @return 带分页的查询结果列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<SysUser> toPostList(SysUser sysUser, HttpServletRequest request) {
		Page<SysUser> page = new Page<SysUser>(request);
		page = sysUserService.selectPage(sysUser, request, page);
		return page;
	}

	/**
	 * 用户管理 - 新增页 - GET
	 * @return 新增页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/insert");
		List<SysRole> roleList = sysRoleService.select(new SysRole(), false);
		mov.addObject("roleList", roleList);
		return mov;
	}

	/**
	 * 用户管理 - 新增操作 - POST
	 * @param sysUser 新增对象
	 * @param sysRoleList 新增用户的角色列表
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(SysUser sysUser, SysRoleList sysRoleList, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysUser/list");
		sysUser.setPassword(SecCredentialsMatcher.encryptPassword(sysUser.getPassword()));
		sysUserService.insert(sysUser, true);
		sysUserRoleService.bundleRolesToUser(sysUser, sysRoleList.getSysRoleList());
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}

	/**
	 * 用户管理 - 删除操作- POST
	 * @param sysUser 要删除的用户对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ReturnMessage toPostDelete(SysUser sysUser) {
		sysUserService.deleteById(sysUser.getId(), true);
		sysUserRoleService.deleteAllRolesByUser(sysUser);
		return buildReturnMessage("success", "", "删除成功！");
	}

	/**
	 * 用户管理 - 编辑页 - GET
	 * @param sysUser 要编辑的用户对象
	 * @return 编辑页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGeUpdate(SysUser sysUser) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/update");
		mov.addObject("sysUser", sysUserService.selectById(sysUser.getId()));
		mov.addObject("roleList", sysRoleService.select(new SysRole(), false));
		mov.addObject("haveRoleList", sysRoleService.selectRolesByUser(sysUser.getId()));
		return mov;
	}

	/**
	 * 用户管理 - 编辑操作 - POST
	 * @param sysUser 要编辑的用户对象
	 * @param sysRoleList 编辑的用户的角色列表
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPosUpdate(SysUser sysUser, SysRoleList sysRoleList, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysUser/list");
		sysUserService.update(sysUser);
		sysUserRoleService.deleteAllRolesByUser(sysUser);
		sysUserRoleService.bundleRolesToUser(sysUser, sysRoleList.getSysRoleList());
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}

}
