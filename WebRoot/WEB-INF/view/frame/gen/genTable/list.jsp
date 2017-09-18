<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sitemesh:title>用户管理</sitemesh:title>

<sitemesh:style>
	<style></style>
</sitemesh:style>

<sitemesh:container>
	<div id="listPage" class="container ">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="page-header">业务表列表</h1>
				<form class="form-inline search-form" id="search-form" style="overflow: auto;">
					<div class="form-group col-sm-4">
						<label for="name">表名:</label>
						<input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名">
					</div>
					<div class="form-group col-sm-4">
						<label for="comments">注释:</label>
						<input type="text" class="form-control" id="comments" name="comments" placeholder="请输入用户名">
					</div>
					<div class="col-sm-4 search-form-btnDiv">
						<a class="btn btn-success" id="refresh-table">搜索</a>
						<a class="btn btn-danger" id="reset-table">重置</a>
						<a data-pjax="true" class="btn btn-primary" href="${ctx}/frame/gen/genTable/selectTable">新增</a>
					</div>
				</form>
				<hr>
				<table id="genTableTable" class="display" width="100%">
					<thead>
						<tr>
							<th>序号</th>
							<th>表名</th>
							<th>注释</th>
							<th>类名</th>
							<th>创建时间</th>
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
						"name" : "name",
						"orderable" : true
					},
					{
						"data" : "comments",
						"name" : "comments",
						"orderable" : true
					},
					{
						"data" : "className",
						"name" : "class_name",
						"orderable" : true
					},
					{
						"data" : "createBy.username",
						"name" : "cu.username",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a data-pjax='true' href='${ctx}/frame/gen/genTable/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/gen/genTable/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#genTableTable'>删除</a>";
							return updateA + " | " + deleteA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#genTableTable", "${ctx}/frame/gen/genTable/list", "#search-form", columns, "#refresh-table", "#reset-table");
		}
	</script>
</sitemesh:script>