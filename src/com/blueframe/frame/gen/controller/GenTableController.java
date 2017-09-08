package com.blueframe.frame.gen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;

/**
 * 代码生成器-业务表 Controller
 */
@Controller
@RequestMapping(value = "/frame/gen/genTable")
public class GenTableController extends BaseController{

	/**
	 * 添加业务表-选择业务表
	 * @return
	 */
	@RequestMapping(value = "/selectTable", method = RequestMethod.GET)
	public ModelAndView toGetSelectTable() {
		ModelAndView mov = new ModelAndView("/frame/gen/genTable/selectTable");
		return mov;
	}
}