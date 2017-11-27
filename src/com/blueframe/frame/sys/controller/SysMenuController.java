package com.blueframe.frame.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.sys.model.SysMenu;
import com.blueframe.frame.sys.service.SysMenuService;

/**
 * 菜单管理
 */
@Controller
@RequestMapping(value = "/frame/sys/sysMenu")
public class SysMenuController extends BaseController {

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 菜单管理-列表页-GET
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList(SysMenu sysMenu) {
		List<SysMenu> sysMenuList = sysMenuService.selectTree(sysMenu, true);
		ModelAndView mov = new ModelAndView("/frame/sys/sysMenu/list");
		mov.addObject("sysMenuList", sysMenuList);
		return mov;
	}

	/**
	 * 菜单管理-新增页-GET
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysMenu/insert");
		return mov;
	}
}
