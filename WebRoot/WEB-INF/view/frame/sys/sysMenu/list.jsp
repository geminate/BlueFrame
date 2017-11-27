<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>菜单管理 - 菜单列表</sitemesh:title>

<!-- 组件 CSS -->
<sitemesh:page_level_plugins_style>

</sitemesh:page_level_plugins_style>

<!-- 自定义 CSS -->
<sitemesh:custom_style>

</sitemesh:custom_style>

<!-- 组件JS -->
<sitemesh:page_level_plugins_script>

</sitemesh:page_level_plugins_script>

<!-- 页面 JS -->
<sitemesh:page_level_script></sitemesh:page_level_script>

<!-- 自定义 JS -->
<sitemesh:custom_script>
	<script>
		$(function() {
			var option = {
				expandLevel : 999
			};
			$("#treeTable1").treeTable(option);
		});
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
				<a href="${ctx}/frame/sys/sysMenu/list">菜单管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysMenu/list">菜单列表</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		菜单管理<small>&emsp;菜单列表&emsp;</small>
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
							<div class="row"></div>
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
							<a class="btn green-jungle btn-sm" href="${ctx}/frame/sys/sysMenu/insert">添加新菜单</a>
						</div>
					</div>
				</div>

				<div class="portlet-body">
					<div class="table-scrollable">
						<table id="treeTable1" class="table table-striped table-hover">
							<thead>
								<tr>
									<th style="width:200px;">标题</th>
									<th>内容</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sysMenuList}" var="item">
									<tr id="${item.id}" pId="${item.parent.id}">
										<td>${item.id}</td>
										<td>${item.parent.id}</td>
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