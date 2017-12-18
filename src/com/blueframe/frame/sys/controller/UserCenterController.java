package com.blueframe.frame.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;

/**
 * 个人中心 Controller
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/sys/userCenter")
public class UserCenterController extends BaseController {

	/**
	 * 个人中心页 - GET
	 * @return
	 */
	@RequestMapping(value = { "", "/profile" }, method = RequestMethod.GET)
	public ModelAndView getProfile() {
		ModelAndView mov = new ModelAndView("/frame/sys/userCenter/profile");
		return mov;
	}

}
