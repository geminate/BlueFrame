package cn.ac.sec.work.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.ac.sec.work.project.model.ProjectPersonal;
import cn.ac.sec.work.project.service.ProjectPersonalService;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.base.model.ReturnMessage;

/**
 * 人员管理 Controller
 * @author hhLiu
 */
@RestController
@RequestMapping(value = "/work/project/projectPersonal")
public class ProjectPersonalController extends BaseController {

	@Autowired
	private ProjectPersonalService projectPersonalService;
	
	/**
	 * 人员管理 - 列表页 - GET
	 * @return 列表页
	 */
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mov = new ModelAndView("/work/project/projectPersonal/list");
		return mov;
	}
	
	/**
	 * 人员管理 - 列表页表格数据Ajax - POST
	 * @param projectPersonal 筛选对象
	 * @param request 请求对象
	 * @return 带分页的查询结果列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<ProjectPersonal> postList(ProjectPersonal projectPersonal, HttpServletRequest request) {
		Page<ProjectPersonal> page = new Page<ProjectPersonal>(request);
		page = projectPersonalService.selectPage(projectPersonal, request, page);
		return page;
	}
	
	/**
	 * 人员管理 - 新增页 - GET
	 * @return 新增页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView getInsert() {
		ModelAndView mov = new ModelAndView("/work/project/projectPersonal/insert");
		return mov;
	}
	
	/**
	 * 人员管理 - 新增操作 - POST
	 * @param projectPersonal 新增对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView postInsert(ProjectPersonal projectPersonal, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/work/project/projectPersonal/list");		
		projectPersonalService.insert(projectPersonal, true);		
		addRedirectToastr(attributes, "success", "", "添加成功！");
		return mov;
	}
	
	/**
	 * 人员管理 - 删除操作- POST
	 * @param projectPersonal 删除对象
	 * @return 返回信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ReturnMessage postDelete(ProjectPersonal projectPersonal) {
		projectPersonalService.deleteById(projectPersonal.getId(), true);
		return buildReturnMessage("success", "", "删除成功！");
	}

	/**
	 * 人员管理 - 编辑页 - GET
	 * @param projectPersonal 编辑对象
	 * @return 编辑页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView getUpdate(ProjectPersonal projectPersonal) {
		ModelAndView mov = new ModelAndView("/work/project/projectPersonal/update");
		mov.addObject("projectPersonal", projectPersonalService.selectById(projectPersonal.getId()));		
		return mov;
	}

	/**
	 * 人员管理 - 编辑操作 - POST
	 * @param projectPersonal 要编辑的用户对象
	 * @param attributes 重定向对象
	 * @return 重定向至列表页
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView postUpdate(ProjectPersonal projectPersonal, RedirectAttributes attributes) {
		ModelAndView mov = new ModelAndView("redirect:/work/project/projectPersonal/list");
		projectPersonalService.update(projectPersonal);
		addRedirectToastr(attributes, "success", "", "编辑成功！");
		return mov;
	}
}