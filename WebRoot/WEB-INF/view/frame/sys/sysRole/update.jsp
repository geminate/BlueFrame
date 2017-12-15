<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>角色管理 - 编辑角色</sitemesh:title>

<!-- 自定义 CSS -->
<sitemesh:custom_style>
</sitemesh:custom_style>

<!-- 自定义 JS -->
<sitemesh:custom_script>
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
				<a href="${ctx}/frame/sys/sysRole/list">角色管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="">编辑角色</a>
			</li>
		</ul>
	</div>
	<h3 class="page-title">
		角色管理<small>&emsp;编辑角色&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>编辑角色
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/sys/sysRole/update" class="horizontal-form" method="post" data-validate>
						<input type="hidden" name="id" value="${sysRole.id}">
						<div class="form-body">
							<h3 class="form-section">角色信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">名称</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="name" type="text" class="form-control required" placeholder="请输入名称" value="${sysRole.name}">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">角色标识</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="roleStr" type="text" class="form-control required" placeholder="请输入角色标识" value="${sysRole.roleStr}">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">简介</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="description" type="text" class="form-control" placeholder="请输入简介" value="${sysRole.description}">
										</div>
									</div>
								</div>
							</div>
							<h3 class="form-section">关联权限</h3>
							<sys:treeSelect value="${sysPermissions}" name="sysPermissions" url="${ctx}/frame/sys/sysPermission/treeAjax" id="sysPermissions" checkable="true"></sys:treeSelect>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-6">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn green">保存</button>
											<button type="button" class="btn default" onclick="window.history.back(-1);">返回</button>
										</div>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</sitemesh:container>

<sitemesh:script>

</sitemesh:script>