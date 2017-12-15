<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>代码生成 - 生成方案管理</sitemesh:title>

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
						"data" : "name",
						"name" : "a.name",
						"orderable" : true
					},
					{
						"data" : "packagePath",
						"name" : "a.package_path",
						"orderable" : true
					},					
					{
						"data" : "modulePath",
						"name" : "a.module_path",
						"orderable" : true
					},
					{
						"data" : "moduleName",
						"name" : "a.module_name",
						"orderable" : true
					},
					{
						"data" : "moduleAuthor",
						"name" : "a.module_author",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a class='btn btn-xs blue' href='${ctx}/frame/gen/genScheme/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a class='btn btn-xs red' href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/gen/genScheme/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#genSchemeTable'>删除</a>";
							var buildA = "<a class='btn btn-xs green-jungle' href='${ctx}/frame/gen/genScheme/build?id=" + row.id + "'>生成</a>";
							return updateA + deleteA + buildA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#genSchemeTable", "${ctx}/frame/gen/genScheme/list", "#searchForm", columns, "#searchBtn", "#resetBtn");
		}
	</script>
</sitemesh:custom_script>

<sitemesh:container>
	<!-- 面包屑 -->
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<a href="index.html">首页</a> <i class="fa fa-angle-right"></i>
			</li>
			<li>
				<span>代码生成</span><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/gen/genScheme">生成方案配置</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/gen/genScheme">生成方案列表</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		生成方案配置<small>&emsp;生成方案列表&emsp;</small>
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
										<label class="control-label">方案名称</label>
										<input name="name" type="text" class="form-control test" placeholder="按方案名称查询(模糊)">
										<span class="help-block"></span>
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
							<a class="btn green-jungle btn-sm" href="${ctx}/frame/gen/genScheme/insert">添加新方案</a>
						</div>
					</div>
				</div>
				<div class="portlet-body">
					<div class="table-container">
						<table id="genSchemeTable" class="table table-striped table-bordered table-hover table-checkable">
							<thead>
								<tr role="row" class="heading">
									<th>序号</th>
									<th>方案名称</th>
									<th>包路径</th>
									<th>模块路径</th>
									<th>模块说明</th>
									<th>模块作者</th>
									<th>操作</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</sitemesh:container>