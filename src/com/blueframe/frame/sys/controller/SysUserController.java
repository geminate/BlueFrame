package com.blueframe.frame.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.common.shiro.SecCredentialsMatcher;
import com.blueframe.frame.sys.model.SysRole;
import com.blueframe.frame.sys.model.SysRoleList;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysRoleService;
import com.blueframe.frame.sys.service.SysUserRoleService;
import com.blueframe.frame.sys.service.SysUserService;

/**
 * 用户管理
 */
@Controller
@RequestMapping(value = "/frame/sys/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	/**
	 * 用户管理-列表页-GET
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/list");
		return mov;
	}

	/**
	 * 用户管理-列表页-表格数据Ajax-POST
	 * @param sysUser
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<SysUser> toPostList(SysUser sysUser, HttpServletRequest request) {
		Page<SysUser> page = new Page<SysUser>(request);
		page = sysUserService.selectPage(sysUser, request, page);
		return page;
	}

	/**
	 * 用户管理-新增页-GET
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/insert");
		List<SysRole> roleList = sysRoleService.select(new SysRole(), false);
		mov.addObject("roleList", roleList);
		return mov;
	}

	/**
	 * 用户管理-新增页-新增操作-POST
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(SysUser sysUser, SysRoleList sysRoleList) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysUser/list");
		sysUser.setPassword(SecCredentialsMatcher.encryptPassword(sysUser.getPassword()));
		sysUserService.insert(sysUser, true);
		sysUserRoleService.bundleRolesToUser(sysUser, sysRoleList.getSysRoleList());
		return mov;
	}

	/**
	 * 用户管理-列表页-删除操作-POST
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String toPostDelete(SysUser sysUser) {
		sysUserService.delete(sysUser, true);
		sysUserRoleService.deleteAllRolesByUser(sysUser);
		return "success";
	}

	/**
	 * 用户管理-编辑页-GET
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGeUpdate(SysUser sysUser) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/update");
		mov.addObject("sysUser", sysUserService.selectOne(sysUser, false));
		mov.addObject("roleList", sysRoleService.select(new SysRole(), false));
		mov.addObject("haveRoleList", sysRoleService.selectRolesByUser(sysUser.getId()));
		return mov;
	}

	/**
	 * 用户管理-编辑页-编辑操作-POST
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPosUpdate(SysUser sysUser, SysRoleList sysRoleList) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysUser/list");
		sysUserService.update(sysUser);
		sysUserRoleService.deleteAllRolesByUser(sysUser);
		sysUserRoleService.bundleRolesToUser(sysUser, sysRoleList.getSysRoleList());
		return mov;
	}
}
