package com.blueframe.frame.gen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blueframe.frame.base.controller.BaseController;
import com.blueframe.frame.base.model.AjaxInfo;
import com.blueframe.frame.base.model.Page;
import com.blueframe.frame.gen.model.GenScheme;
import com.blueframe.frame.gen.model.GenTable;
import com.blueframe.frame.gen.service.GenSchemeService;
import com.blueframe.frame.gen.service.GenTableService;

/**
 * 代码生成器-生成方案 Controller
 */
@RestController
@RequestMapping(value = "/frame/gen/genScheme")
public class GenSchemeController extends BaseController {

	@Autowired
	private GenSchemeService genSchemeService;

	@Autowired
	private GenTableService genTableService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toGetList() {
		ModelAndView mov = new ModelAndView("/frame/gen/genScheme/list");
		return mov;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<GenScheme> toPostList(GenScheme genScheme, HttpServletRequest request) {
		Page<GenScheme> page = new Page<GenScheme>(request);
		page = genSchemeService.selectPage(genScheme, request, page);
		return page;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView toGetInsert() {
		ModelAndView mov = new ModelAndView("/frame/gen/genScheme/insert");
		List<GenTable> genTables = genTableService.select(new GenTable(), false);
		mov.addObject("genTables", genTables);
		return mov;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView toPostInsert(GenScheme genScheme) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genScheme/list");
		genSchemeService.insert(genScheme, true);
		return mov;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public AjaxInfo toPostDelete(GenScheme genScheme) {
		genSchemeService.delete(genScheme, true);
		return new AjaxInfo("success");
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView toGetUpdate(GenScheme genScheme) {
		ModelAndView mov = new ModelAndView("/frame/gen/genScheme/update");
		genScheme = genSchemeService.selectOne(genScheme, false);
		mov.addObject("genScheme", genScheme);
		List<GenTable> genTables = genTableService.select(new GenTable(), false);
		mov.addObject("genTables", genTables);
		return mov;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView toPostUpdate(GenScheme genScheme) {
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genScheme/list");
		genSchemeService.update(genScheme);
		return mov;
	}

	@RequestMapping(value = "/build")
	public ModelAndView toBuild(GenScheme genScheme) {
		genScheme = genSchemeService.selectOne(genScheme, false);
		genSchemeService.build(genScheme);
		ModelAndView mov = new ModelAndView("redirect:/frame/gen/genScheme/list");
		return mov;
	}
}
