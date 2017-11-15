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
				<h1 class="page-header">用户列表</h1>
				<form class="form-inline search-form" id="search-form" style="overflow: auto;">
					<div class="form-group col-sm-4">
						<label for="username">用户名:</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
					</div>
					<div class="form-group col-sm-4">
						<label>测试:</label>
						<select class="select2"></select>
					</div>
					<div class="col-sm-4 search-form-btnDiv">
						<a class="btn btn-success" id="refresh-table">搜索</a> <a class="btn btn-danger" id="reset-table">重置</a> <a data-pjax="true" class="btn btn-primary"
							href="${ctx}/frame/sys/sysUser/insert">新增</a>
					</div>
				</form>
				<hr>
				<table id="sysUserTable" class="display" width="100%">
					<thead>
						<tr>
							<th>序号</th>
							<th>用户名</th>
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
						"data" : "username",
						"name" : "username",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a href='${ctx}/frame/sys/sysUser/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/sys/sysUser/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#sysUserTable'>删除</a>";
							return updateA + " | " + deleteA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#sysUserTable", "${ctx}/frame/sys/sysUser/list", "#search-form", columns, "#refresh-table", "#reset-table");
		}
	</script>
</sitemesh:script>