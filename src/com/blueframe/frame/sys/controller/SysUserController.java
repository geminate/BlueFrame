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
import com.blueframe.frame.base.model.AjaxInfo;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysUserService;

/**
 * 用户管理
 */
@Controller
@RequestMapping(value = "/frame/sys/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 用户管理-列表页-GET
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetSysUserList() {
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
	public Page<SysUser> toPostSysUserList(SysUser sysUser, HttpServletRequest request) {
		Page<SysUser> page = new Page<SysUser>(request);
		page = sysUserService.selectPage(sysUser, request, page);
		return page;
	}

	/**
	 * 用户管理-新增页-GET
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetSysUserInsert() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/insert");
		return mov;
	}

	/**
	 * 用户管理-新增页-新增操作-POST
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostSysUserInsert(SysUser sysUser) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysUser/list");
		sysUserService.insert(sysUser, true);
		return mov;
	}

	/**
	 * 用户管理-列表页-删除操作-POST
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxInfo toPostSysUserDelete(SysUser sysUser) {
		sysUserService.delete(sysUser, true);
		return new AjaxInfo("success");
	}

	/**
	 * 用户管理-编辑页-GET
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGetSysUserUpdate(SysUser sysUser) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysUser/update");
		List<SysUser> sysUsers = sysUserService.select(sysUser, false);
		if (sysUsers != null && sysUsers.size() > 0) {
			mov.addObject("sysUser", sysUsers.get(0));
		}
		return mov;
	}

	/**
	 * 用户管理-编辑页-编辑操作-POST
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPostSysUserUpdate(SysUser sysUser) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysUser/list");
		sysUserService.update(sysUser);
		return mov;
	}
}
