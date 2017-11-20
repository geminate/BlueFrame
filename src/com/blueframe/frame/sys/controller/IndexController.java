package com.blueframe.frame.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
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
	 * 模板路径
	 */
	@RequestMapping(value = "/decorator", method = RequestMethod.GET)
	public ModelAndView getDecorator() {
		ModelAndView mov = new ModelAndView("/frame/sys/index/decorator");
		return mov;
	}

	/**
	 * 工作台首页 GET
	 * @param mov
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView getIndex(ModelAndView mov) {
		// System.out.println(SecurityUtils.getSubject().hasRole("0001"));
		mov.setViewName("/frame/sys/index/index");
		return mov;
	}

	/**
	 * 登录页 GET
	 * @param mov
	 * @param servlet
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(ModelAndView mov, DispatcherServlet servlet) {
		mov.setViewName("/frame/sys/index/login");
		return mov;
	}

	/**
	 * 登录请求 POST
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ReturnMessage postLogin(SysUser sysUser) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
		try {
			SecurityUtils.getSubject().login(usernamePasswordToken);
			return buildReturnMessage("0", "登陆成功");
		} catch (Exception e) {
			return buildReturnMessage("1", "用户名密码错误");
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView getLogout(ModelAndView mov) {
		if (SecurityUtils.getSubject().getPrincipal() != null) {
			SecurityUtils.getSubject().logout();
		}
		mov.setViewName("redirect:/login");
		return mov;

	}
}