package com.blueframe.frame.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.ReturnMessage;
import com.blueframe.frame.common.component.shiro.SecCredentialsMatcher;
import com.blueframe.frame.common.utils.UserUtil;
import com.blueframe.frame.sys.model.SysUser;
import com.blueframe.frame.sys.service.SysUserService;

/**
 * 账户设定 Controller
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/sys/account")
public class AccountController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 账户设定页 - GET
	 * @return 账户设定页
	 */
	@RequestMapping(value = { "", "/setting" }, method = RequestMethod.GET)
	public ModelAndView getSetting() {
		ModelAndView mov = new ModelAndView("/frame/sys/account/setting");
		return mov;
	}

	/**
	 * 账户设定页 - 修改个人信息 - POST
	 * @param sysUser 修改对象
	 * @param attributes 重定向对象
	 * @return 重定向至设定页
	 */
	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public ModelAndView postChangeInfo(SysUser sysUser, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/account/setting");
		sysUser.setId((UserUtil.getCurrentUser().getId()));
		sysUserService.update(sysUser);
		UserUtil.reFreshLoginInfo(sysUser);
		addRedirectToastr(attributes, "success", "", "修改成功！");
		return mov;
	}

	@RequestMapping(value = "/changeAvatar", method = RequestMethod.POST)
	public ModelAndView postChangeAvatar(HttpServletRequest request, RedirectAttributes attributes) {
		List<MultipartFile> files = sysUserService.requestToFiles(request);
		// TODO 
		// 1. 把图片保存起来
		// 2. 向附件表里面 插入一条数据
		// 3. 修改用户表中的Avatar字段为附件ID
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/account/setting");
		addRedirectToastr(attributes, "success", "", "修改成功！");
		return mov;
	}

	/**
	 * 账户设定页 - 检查原密码是否正确 - POST
	 * @param value 输入的密码
	 * @return Ajax 返回信息
	 */
	@RequestMapping(value = "/checkPassword", method = RequestMethod.POST)
	public ReturnMessage postCheckPassword(String value) {
		String password = UserUtil.getCurrentUser().getPassword();
		if (SecCredentialsMatcher.encryptPassword(value).equals(password)) {
			return buildReturnMessage("success", "", "");
		} else {
			return buildReturnMessage("fail", "", "");
		}
	}

	/**
	 * 账户设定页 - 修改密码 - POST
	 * @param password 原密码
	 * @param newPassword 新密码
	 * @param attributes 重定向对象
	 * @return 重定向至设定页
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView postChangePassword(String password, String newPassword, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/account/setting");
		String oldPassword = UserUtil.getCurrentUser().getPassword();
		if (SecCredentialsMatcher.encryptPassword(password).equals(oldPassword)) {
			SysUser sysUser = new SysUser();
			sysUser.setPassword(SecCredentialsMatcher.encryptPassword(newPassword));
			sysUser.setId(UserUtil.getCurrentUser().getId());
			sysUserService.update(sysUser);
			UserUtil.reFreshLoginInfo(sysUser);
			addRedirectToastr(attributes, "success", "", "修改成功！");
		} else {
			addRedirectToastr(attributes, "error", "", "修改失败！密码不正确");
		}
		return mov;
	}
}
