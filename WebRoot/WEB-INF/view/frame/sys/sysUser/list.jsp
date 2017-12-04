<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>用户管理 - 用户列表</sitemesh:title>

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
						"data" : "username",
						"name" : "a.username",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"data" : "createDate",
						"name" : "a.create_date",
						"defaultContent" : "",
						"orderable" : true
					},
					{
						"render" : function(data, type, row, meta) {
							var updateA = "<a class='btn btn-xs blue' href='${ctx}/frame/sys/sysUser/update?id=" + row.id + "'>编辑</a>";
							var deleteA = "<a class='btn btn-xs red'  href='javascript:' onclick='GLOBAL.DATATABLE.deleteRow(this)'" + " data-datatable-url='${ctx}/frame/sys/sysUser/delete'" + " data-datatable-param='" + row.id + "'"
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
										<input name="name" type="text" class="form-control test" placeholder="按姓名查询(模糊)">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">用户名</label>
										<input name="username" type="text" class="form-control" placeholder="按用户名查询(模糊)">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">创建日期</label>
										<div class="input-group date date-picker input-daterange" data-date-format="yyyy-mm-dd">
											<input type="text" class="form-control" name="createDateBegin" placeholder="起始日期">
											<span class="input-group-addon"> 至 </span>
											<input type="text" class="form-control" name="createDateEnd" placeholder="结束日期">
										</div>
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
							<a class="btn green-jungle btn-sm" href="${ctx}/frame/sys/sysUser/insert">添加新用户</a>
						</div>
					</div>
				</div>

				<div class="portlet-body">
					<div class="table-container">

						<table class="table table-striped table-bordered table-hover table-checkable" id="sysUserTable">
							<thead>
								<tr role="row" class="heading">
									<th>序号</th>
									<th>姓名</th>
									<th>用户名</th>
									<th>创建日期</th>
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