package com.blueframe.frame.decorator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;

@Controller
@RequestMapping(value = "/frame/decorators")
public class DecoratorController extends BaseController {

	@RequestMapping(value = "/decorator", method = RequestMethod.GET)
	public ModelAndView toGetDecorator() {
		ModelAndView mov = new ModelAndView("/frame/decorators/decorator");
		return mov;
	}

}
