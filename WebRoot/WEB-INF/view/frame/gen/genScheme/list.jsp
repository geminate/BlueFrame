<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sitemesh:title>生成方案管理</sitemesh:title>

<sitemesh:style>
	<style></style>
</sitemesh:style>

<sitemesh:container>
	<div id="listPage" class="container ">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="page-header">生成方案列表</h1>
				<form class="form-inline search-form" id="search-form" style="overflow: auto;">
					<div class="form-group col-sm-4">
						<label for="name">方案名称:</label>
						<input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名">
					</div>
					<div class="col-sm-4 search-form-btnDiv">
						<a class="btn btn-success" id="refresh-table">搜索</a> <a class="btn btn-danger" id="reset-table">重置</a> <a data-pjax="true" class="btn btn-primary"
							href="${ctx}/frame/gen/genScheme/insert">新增</a>
					</div>
				</form>
				<hr>
				<table id="genSchemeTable" class="display" width="100%">
					<thead>
						<tr>
							<th>序号</th>
							<th>方案名称</th>
							<th>生成模块</th>
							<th>模块名</th>
							<th>功能名</th>
							<th>功能作者</th>
							<th>操作</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</sitemesh:container>

<sitemesh:script>
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
						"data" : "packageName",
						"name" : "a.package_name",
						"orderable" : true
					},
					{
						"data" : "moduleName",
						"name" : "a.module_name",
						"orderable" : true
					},
					{
						"data" : "functionName",
						"name" : "a.function_name",
						"orderable" : true
					},
					{
						"data" : "functionAuthor",
						"name" : "a.function_author",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a data-pjax='true' href='${ctx}/frame/gen/genScheme/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/gen/genScheme/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#genSchemeTable'>删除</a>";
							var buildA = "<a href='${ctx}/frame/gen/genScheme/build?id=" + row.id + "'>生成</a>";
							return updateA + " | " + deleteA + " | " + buildA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#genSchemeTable", "${ctx}/frame/gen/genScheme/list", "#search-form", columns, "#refresh-table", "#reset-table");
		}
	</script>
</sitemesh:script>