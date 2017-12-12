package com.blueframe.frame.base.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blueframe.frame.base.model.ReturnMessage;

/**
 * Controller 基类
 * @author hhLiu
 */
public class BaseController {

	@ModelAttribute
	public void setHeader(HttpServletResponse response) {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
	}

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

	/**
	 * Java 后台验证
	 * @param entity 验证对象
	 * @param groups 验证组
	 * @return 验证返回信息列表
	 */
	public static <T> List<String> validate(T entity, Class<?>... groups) {
		List<String> validateErrors = new ArrayList<>();
		ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = vFactory.getValidator();
		Set<ConstraintViolation<T>> set = validator.validate(entity, groups);
		if (set.size() > 0) {
			for (ConstraintViolation<T> val : set) {
				validateErrors.add(val.getMessage());
			}
		}
		return validateErrors;
	}

	/**
	 * 验证对象的单独属性
	 * @param entity 验证对象
	 * @param propertyName 属性名
	 * @param groups 验证组
	 * @return 验证返回信息列表
	 */
	public static <T> List<String> validateProp(T entity, String propertyName, Class<?>... groups) {
		List<String> validateErrors = new ArrayList<>();
		ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = vFactory.getValidator();
		Set<ConstraintViolation<T>> set = validator.validateProperty(entity, propertyName, groups);
		if (set.size() > 0) {
			for (ConstraintViolation<T> val : set) {
				validateErrors.add(val.getMessage());
			}
		}
		return validateErrors;
	}
}
