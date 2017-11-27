<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>权限管理 - 权限列表</sitemesh:title>

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
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"data" : "permissionStr",
						"name" : "a.permission_str",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a class='btn btn-xs blue' href='${ctx}/frame/sys/sysPermission/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a class='btn btn-xs red' href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/sys/sysPermission/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#sysPermissionTable'>删除</a>";
							return updateA + deleteA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#sysPermissionTable", "${ctx}/frame/sys/sysPermission/list", "#searchForm", columns, "#searchBtn", "#resetBtn");
		}
	</script>
</sitemesh:custom_script>

<!----------------------------------------------------------------- 以下为主体内容 -------------------------------------------------------------------->

<sitemesh:container>
	<!-- 面包屑 -->
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<a href="index.html">首页</a> <i class="fa fa-angle-right"></i>
			</li>
			<li>
				<span>系统管理</span><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysPermission/list">权限管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysPermission/list">权限列表</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		权限管理<small>&emsp;权限列表&emsp;</small>
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
										<label class="control-label">名称</label>
										<input name="name" type="text" class="form-control" placeholder="按权限名称查询(模糊)">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">标记</label>
										<input name="PermissionStr" type="text" class="form-control" placeholder="按权限标记查询(模糊)">
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
							<a class="btn green-jungle btn-sm" href="${ctx}/frame/sys/sysPermission/insert">添加新权限</a>
						</div>
					</div>
				</div>
				<div class="portlet-body">
					<div class="table-container">
						<form id="searchForm">
							<table class="table table-striped table-bordered table-hover table-checkable" id="sysPermissionTable">
								<thead>
									<tr role="row" class="heading">
										<th>序号</th>
										<th>权限名称</th>
										<th>权限标记</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</sitemesh:container>