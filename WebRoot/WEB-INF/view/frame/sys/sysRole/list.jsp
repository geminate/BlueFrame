<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>角色管理 - 角色列表</sitemesh:title>

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
						"data" : "roleStr",
						"name" : "a.role_str",
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
							var updateA = "<a class='btn btn-xs blue' href='${ctx}/frame/sys/sysRole/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a class='btn btn-xs red' href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/sys/sysRole/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#sysRoleTable'>删除</a>";
							return updateA + deleteA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#sysRoleTable", "${ctx}/frame/sys/sysRole/list", "#searchForm", columns, "#searchBtn", "#resetBtn");
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
				<span>系统管理</span><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysRole/list">角色管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysRole/list">角色列表</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		角色管理<small>&emsp;角色列表&emsp;</small>
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
										<label class="control-label">姓名</label>
										<input name="name" type="text" class="form-control" placeholder="按角色名称查询(模糊)">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">用户名</label>
										<input name="roleStr" type="text" class="form-control" placeholder="按角色标记查询(模糊)">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">简介</label>
										<input name="description" type="text" class="form-control" placeholder="按角色简介查询(模糊)">
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
					<!-- END FORM-->
				</div>
			</div>

			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>查询结果
					</div>
					<div class="actions">
						<div class="btn-group btn-group-devided">
							<a class="btn green-jungle btn-sm" href="${ctx}/frame/sys/sysRole/insert">添加新角色</a>
						</div>
					</div>
				</div>
				<div class="portlet-body">
					<div class="table-container">
						<table class="table table-striped table-bordered table-hover table-checkable" id="sysRoleTable">
							<thead>
								<tr role="row" class="heading">
									<th>序号</th>
									<th>角色名称</th>
									<th>角色标记</th>
									<th>角色简介</th>
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