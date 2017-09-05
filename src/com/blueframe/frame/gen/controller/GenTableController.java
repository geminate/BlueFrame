package com.blueframe.frame.gen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/gen/genTable")
public class GenTableController {

	@ResponseBody
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String toGetWorkSchool() {
		return "123";
	}
}