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
			initListener();
		});

		function initListener() {
			$("#permissionTable").on("click", ".del-btn", function() {
				var url = $(this).parents("table").attr("delUrl");
				var id = $(this).parents("tr").attr("id");
				$.confirm({
					title : "确定删除？",
					type : "orange",
					backgroundDismiss : true,
					content : "",
					buttons : {
						"确定" : {
							btnClass : "btn-success",
							action : function() {
								window.location.href = url + "?id=" + id
							}
						},
						"取消" : {
							btnClass : 'btn-danger'
						}
					}
				});
			});

			$("#resetBtn").click(function() {
				var $form = $(this).parents("form");
				$form.find(":input").not(':button,:submit,:reset,:hidden').val('').removeAttr('checked').removeAttr('selected');
				$form[0].submit();
			});
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
					<form id="searchForm" class="horizontal-form" action="${ctx}/frame/sys/sysPermission/list" method="post">
						<div class="form-body">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">名称</label>
										<input name="name" type="text" class="form-control" placeholder="按权限名称查询(模糊)" value="${sysPermission.name}">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">标记</label>
										<input name="PermissionStr" type="text" class="form-control" placeholder="按权限标记查询(模糊)" value="${sysPermission.permissionStr}">
										<span class="help-block"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="form-actions right">
							<button id="searchBtn" type="submit" class="btn green">查询</button>
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
					<div class="table-scrollable">
						<table id="permissionTable" class="table tree-table table-striped table-hover" delUrl="${ctx}/frame/sys/sysPermission/delete">
							<thead>
								<tr>
									<th>名称</th>
									<th>菜单地址</th>
									<th>权限标识</th>
									<th>菜单标识</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sysPermissionList}" var="item">
									<tr id="${item.id}" pId="${item.parent.id}">
										<td>${item.name}</td>
										<td>${item.href}</td>
										<td>${item.permissionStr}</td>
										<td>${item.type}</td>
										<td>
											<a class="btn btn-xs blue" href="${ctx}/frame/sys/sysPermission/update?id=${item.id}">编辑</a>
											<a class="btn btn-xs red del-btn" href="javascript:">删除</a>
											<a class="btn btn-xs green" href="${ctx}/frame/sys/sysPermission/insert?parent.id=${item.id}">添加下级菜单</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</sitemesh:container>