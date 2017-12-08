package com.blueframe.frame.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.ReturnMessage;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysPermissionService;

/**
 * 基础 Controller
 */
@RestController
public class IndexController extends BaseController {

	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 模板页 - GET,POST
	 * @return 模板页面
	 */
	@RequestMapping(value = "/decorator")
	public ModelAndView decorator() {
		ModelAndView mov = new ModelAndView("/frame/sys/index/decorator");
		return mov;
	}

	/**
	 * 工作台 - 首页 - GET
	 * @return 工作台页面
	 * @throws Exception
	 */
	@RequestMapping("/")
	public ModelAndView getIndex() {
		ModelAndView mov = new ModelAndView("redirect:/desktop");
		return mov;
	}

	/**
	 * 工作台 - 首页 - GET
	 * @return 工作台页面
	 * @throws Exception
	 */
	@RequestMapping("/desktop")
	public ModelAndView getDesktop() {
		ModelAndView mov = new ModelAndView("/frame/sys/index/desktop");
		return mov;
	}

	/**
	 * 登录页 - GET
	 * @return 登录页
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		ModelAndView mov = new ModelAndView("/frame/sys/index/login");
		return mov;
	}

	/**
	 * 登录页 - 登录请求 - POST
	 * @param sysUser 登录请求对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ReturnMessage postLogin(SysUser sysUser) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
		try {
			SecurityUtils.getSubject().login(usernamePasswordToken);
			return buildReturnMessage("success", "", "登陆成功");
		} catch (Exception e) {
			return buildReturnMessage("fail", "", "用户名密码错误");
		}
	}

	/**
	 * 登出请求 - GET
	 * @return 重定向至登录页
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView getLogout() {
		if (SecurityUtils.getSubject().getPrincipal() != null) {
			SecurityUtils.getSubject().logout();
		}
		ModelAndView mov = new ModelAndView("redirect:/login");
		return mov;
	}

	/**
	 * 404页面 - GET,POST
	 * @return 404页面
	 */
	@RequestMapping(value = "/error-404")
	public ModelAndView error404() {
		ModelAndView mov = new ModelAndView("/error/404");
		return mov;
	}

	/**
	 * 500页面 - GET,POST
	 * @return 500页面
	 */
	@RequestMapping(value = "/error-500")
	public ModelAndView error500() {
		ModelAndView mov = new ModelAndView("/error/500");
		return mov;
	}

}