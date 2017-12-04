package com.blueframe.frame.base.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blueframe.frame.base.model.ReturnMessage;

/**
 * Controller 基类
 * @author hhLiu
 */
public class BaseController {

	/**
	 * 添加 AJAX 返回对象
	 * @param type 返回标识
	 * @param title 返回信息标题
	 * @param message 返回信息主体
	 * @return AJAX返回对象，包含type、title、message三个属性
	 */
	public ReturnMessage buildReturnMessage(String type, String title, String message) {
		return new ReturnMessage(type, title, message);
	}

	/**
	 * 添加重定向返回提示信息
	 * @param attributes 重定向对象
	 * @param type 提示类型
	 * @param title 提示信息标题
	 * @param message 提示信息主体
	 */
	public void addRedirectToastr(RedirectAttributes attributes, String type, String title, String message) {
		attributes.addFlashAttribute("toastrType", type);
		attributes.addFlashAttribute("toastrTitle", title);
		attributes.addFlashAttribute("toastrMessage", message);
	}
}
