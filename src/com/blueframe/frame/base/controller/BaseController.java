package com.blueframe.frame.base.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

public class BaseController {

	@ModelAttribute
	public Model get(@RequestHeader(value = "X-PJAX", required = false) String pjax, Model model) {
		if (null != pjax) {
			model.addAttribute("PJAX", "1");
		}
		return model;
	}
}
