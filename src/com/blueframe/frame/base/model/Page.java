package com.blueframe.frame.base.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class Page<T> {

	private Integer length; // 页面数据数量
	private Integer start; // 起始数据
	private Integer draw;

	private List<T> data;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private String order;
	private String orderDir;

	public Page(HttpServletRequest request) {
		this.length = Integer.parseInt(request.getParameter("length"));
		this.start = Integer.parseInt(request.getParameter("start"));
		this.draw = Integer.parseInt(request.getParameter("draw"));
		String index = request.getParameter("order[0][column]");
		this.setOrderDir(request.getParameter("order[0][dir]"));
		this.setOrder(request.getParameter("columns[" + index + "][name]"));
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}

	@Override
	public String toString() {
		JSONObject json = JSONObject.fromObject(this);
		return json.toString();
	}
}
