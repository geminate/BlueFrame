<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>用户管理 - 用户列表</sitemesh:title>

<!-- 组件 CSS -->
<sitemesh:page_level_plugins_style>
	<link href="${ctxStatic}/metronic/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
	<link href="${ctxStatic}/metronic/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${ctxStatic}/metronic/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />
</sitemesh:page_level_plugins_style>

<!-- 自定义 CSS -->
<sitemesh:custom_style></sitemesh:custom_style>

<!-- 组件JS -->
<sitemesh:page_level_plugins_script>
	<script src="${ctxStatic}/metronic/global/scripts/datatable.js" type="text/javascript"></script>
	<script src="${ctxStatic}/metronic/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/metronic/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
	<script src="${ctxStatic}/metronic/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
</sitemesh:page_level_plugins_script>

<!-- 页面 JS -->
<sitemesh:page_level_script></sitemesh:page_level_script>

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
						"name" : "name",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"data" : "username",
						"name" : "username",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a class='btn btn-xs blue' href='${ctx}/frame/sys/sysUser/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a class='btn btn-xs red' href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/sys/sysUser/delete'" + " data-datatable-param='" + row.id + "'"
									+ " data-datatable-table='#sysUserTable'>删除</a>";
							return updateA + deleteA;
						},
						"orderable" : false
					} ];

			GLOBAL.DATATABLE.initDatatable("#sysUserTable", "${ctx}/frame/sys/sysUser/list", "#searchForm", columns, "#searchBtn", "#resetBtn");
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
				<a href="${ctx}/frame/sys/sysUser/list">用户管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysUser/list">用户列表</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		用户管理<small>&emsp;用户列表&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet light portlet-fit portlet-datatable bordered">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-user font-dark"></i> <span class="caption-subject font-dark sbold uppercase">用户列表</span>
					</div>
					<div class="actions">
						<div class="btn-group">
							<a class="btn btn-sm sbold green" href="${ctx}/frame/sys/sysUser/insert">添加新用户 <i class="fa fa-plus"></i>
							</a>
						</div>
					</div>
				</div>

				<div class="portlet-body">
					<div class="table-container">
						<form id="searchForm">
							<table class="table table-striped table-bordered table-hover table-checkable" id="sysUserTable">
								<thead>
									<tr role="row" class="heading">
										<th>序号</th>
										<th>姓名</th>
										<th>用户名</th>
										<th>操作</th>
									</tr>
									<tr role="row" class="filter">
										<td></td>
										<td>
											<input type="text" class="form-control form-filter input-sm" name="name" placeholder="按姓名查询(模糊)">
										</td>
										<td>
											<input type="text" class="form-control form-filter input-sm" name="username" placeholder="按姓名查询(模糊)">
										</td>
										<td>
											<button type="button" class="btn btn-sm green btn-outline filter-submit" id="searchBtn">
												<i class="fa fa-search"></i> 查找
											</button>

											<button type="button" class="btn btn-sm red btn-outline filter-cancel" id="resetBtn">
												<i class="fa fa-times"></i> 重置
											</button>
										</td>
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