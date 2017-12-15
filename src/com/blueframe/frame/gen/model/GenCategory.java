package com.blueframe.frame.gen.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.blueframe.frame.sys.model.SysDict;

/**
 * 模板 类型 对象
 * @author hhLiu
 */
@XmlRootElement(name = "category")
public class GenCategory extends SysDict {

	private static final long serialVersionUID = 1L;

	private List<String> template = new ArrayList<>(); // 模板

	@XmlElement(name = "template")
	public List<String> getTemplate() {
		return template;
	}

	public void setTemplate(List<String> template) {
		this.template = template;
	}

}
