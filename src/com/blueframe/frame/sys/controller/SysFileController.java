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

import com.blueframe.frame.sys.model.SysFile;
import com.blueframe.frame.sys.service.SysFileService;
import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.base.model.ReturnMessage;

/**
 * 附件管理 Controller
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/frame/sys/sysFile")
public class SysFileController extends BaseController {

	@Autowired
	private SysFileService sysFileService;

	/**
	 * 附件管理 - 列表页 - GET
	 * @return 列表页
	 */
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysFile/list");
		return mov;
	}

	/**
	 * 附件管理 - 列表页表格数据Ajax - POST
	 * @param sysFile 筛选对象
	 * @param request 请求对象
	 * @return 带分页的查询结果列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<SysFile> postList(SysFile sysFile, HttpServletRequest request) {
		Page<SysFile> page = new Page<SysFile>(request);
		page = sysFileService.selectPage(sysFile, request, page);
		return page;
	}

	/**
	 * 附件管理 - 新增页 - GET
	 * @return 新增页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView getInsert() {
		ModelAndView mov = new ModelAndView("/frame/sys/sysFile/insert");
		return mov;
	}

	/**
	 * 附件管理 - 新增操作 - POST
	 * @param sysFile 新增对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView postInsert(SysFile sysFile, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysFile/list");
		sysFileService.insert(sysFile, true);
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}

	/**
	 * 附件管理 - 删除操作- POST
	 * @param sysFile 删除对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ReturnMessage postDelete(SysFile sysFile) {
		sysFileService.deleteById(sysFile.getId(), true);
		return buildReturnMessage("success", "", "删除成功！");
	}

	/**
	 * 附件管理 - 编辑页 - GET
	 * @param sysFile 编辑对象
	 * @return 编辑页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView getUpdate(SysFile sysFile) {
		ModelAndView mov = new ModelAndView("/frame/sys/sysFile/update");
		mov.addObject("sysFile", sysFileService.selectById(sysFile.getId()));
		return mov;
	}

	/**
	 * 附件管理 - 编辑操作 - POST
	 * @param sysFile 要编辑的用户对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView postUpdate(SysFile sysFile, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/frame/sys/sysFile/list");
		sysFileService.update(sysFile);
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ReturnMessage postUploadFile(HttpServletRequest request, SysFile sysFile) {
		List<MultipartFile> multipartFiles = sysFileService.requestToFiles(request);
		System.out.println(sysFile);
		System.out.println(multipartFiles);
		return buildReturnMessage("success", "", "123456789");
	}
}