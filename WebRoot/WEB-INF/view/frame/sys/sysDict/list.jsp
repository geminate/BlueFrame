<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>字典项管理 - 列表页</sitemesh:title>

<!-- 自定义 CSS -->
<sitemesh:custom_style>
</sitemesh:custom_style>

<!-- 自定义 JS -->
<sitemesh:custom_script>
	<script>
		$(function() {
			initTable();
		});

		function initTable() {
			var columns = [
					{
						"render" : function(data, type, row, meta) {
							return meta.row + 1;
						},
						"orderable" : false
					},
					{
						"data" : "label",
						"name" : "a.label",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"data" : "value",
						"name" : "a.value",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"data" : "type",
						"name" : "a.type",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"data" : "sort",
						"name" : "a.sort",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"data" : "description",
						"name" : "a.description",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a class='btn btn-xs blue' href='${ctx}/frame/sys/sysDict/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a class='btn btn-xs red' href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/sys/sysDict/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#sysDictTable'>删除</a>";
							return updateA + deleteA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#sysDictTable", "${ctx}/frame/sys/sysDict/list", "#searchForm", columns, "#searchBtn", "#resetBtn");
		}
	</script>
</sitemesh:custom_script>

<!----------------------------------------------------------------- 以下为主体内容 -------------------------------------------------------------------->

<sitemesh:container>
	<!-- 面包屑 -->
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<a href="${ctx}/">首页</a> <i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysDict/list">字典项管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysDict/list">列表页</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		字典项管理<small>&emsp;列表页&emsp;</small>
	</h3>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>查询条件
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" data-original-title="" title=""> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form id="searchForm" class="horizontal-form">
						<div class="form-body">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">标签名</label>
										<input name="label" type="text" class="form-control" placeholder="按标签名查询(模糊)">
									</div>
								</div>								
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">分类</label>
										<select name="type" class="select2 form-control">
											<option value=""></option>
											<c:forEach items="${allTypeList}" var="item">
												<option value="${item}">${item}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">简介</label>
										<input name="description" type="text" class="form-control" placeholder="按简介查询(模糊)">
									</div>
								</div>
							</div>
						</div>
						<div class="form-actions right">
							<button id="searchBtn" type="button" class="btn green">查询</button>
							<button id="resetBtn" type="button" class="btn default">重置</button>
						</div>
					</form>
				</div>
			</div>
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>查询结果
					</div>
					<div class="actions">
						<div class="btn-group btn-group-devided">
							<a class="btn green-jungle btn-sm" href="${ctx}/frame/sys/sysDict/insert">添加</a>
						</div>
					</div>
				</div>
				<div class="portlet-body">
					<div class="table-container">
						<table class="table table-striped table-bordered table-hover table-checkable" id="sysDictTable">
							<thead>
								<tr role="row" class="heading">
									<th>序号</th>
									<th>标签名</th>
									<th>数据值</th>
									<th>分类</th>
									<th>排序</th>
									<th>简介</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</sitemesh:container>