package com.blueframe.frame.base.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

/**
 * 分页对象
 * @author hhLiu
 */
public class Page<T> {

	/**
	 * 每页显示的数据条数
	 */
	private Integer length;

	/**
	 * 页面起始数据序号<br>
	 * 从0开始
	 */
	private Integer start; // 起始数据

	/**
	 * dataTable 唯一标识符
	 */
	private Integer draw;

	/**
	 * 查询结果List
	 */
	private List<T> data;

	/**
	 * 数据总量
	 */
	private Integer recordsTotal;

	/**
	 * 筛选后数据量
	 */
	private Integer recordsFiltered;

	/**
	 * 排序的属性名
	 */
	private String order;

	/**
	 * 排序方式<br>
	 * asc 或 desc
	 */
	private String orderDir;

	/**
	 * 构造方法 将Datatable的请求参数 转换为 Page对象
	 * @param request 请求对象
	 */
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
