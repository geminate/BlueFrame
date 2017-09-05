package com.blueframe.frame.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysUserService;

@Controller
@RequestMapping(value = "/frame/sys/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toGetSysUserList() {
		return "/frame/sys/sysUser/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<SysUser> toPostSysUserList(SysUser sysUser, HttpServletRequest request) {
		Page<SysUser> page = new Page<SysUser>(request);
		page = sysUserService.selectPage(sysUser, request, page);
		return page;
	}
}
