package com.blueframe.frame.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.sys.service.SysUserService;

@RestController
public class IndexController extends BaseController {

	@Autowired
	private SysUserService sysUserService;
}