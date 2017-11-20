<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>用户管理 - 添加用户</sitemesh:title>

<!-- 组件 CSS -->
<sitemesh:page_level_plugins_style>
</sitemesh:page_level_plugins_style>

<!-- 自定义 CSS -->
<sitemesh:custom_style></sitemesh:custom_style>

<!-- 组件JS -->
<sitemesh:page_level_plugins_script>
</sitemesh:page_level_plugins_script>

<!-- 页面 JS -->
<sitemesh:page_level_script>
</sitemesh:page_level_script>

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
				<a href="${ctx}/frame/sys/sysUser/list">用户管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysUser/insert">添加用户</a>
			</li>
		</ul>
	</div>

	<h3 class="page-title">
		用户管理<small>&emsp;添加用户&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>添加用户
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/sys/sysUser/insert" class="horizontal-form" method="post">
						<div class="form-body">
							<h3 class="form-section">用户信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">姓名</label>
										<input name="name" type="text" class="form-control" placeholder="请输入姓名">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">用户名</label>
										<input name="username" type="text" class="form-control" placeholder="请输入用户名">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">密码</label>
										<input name="password" type="text" class="form-control" placeholder="请输入密码">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">确认密码</label>
										<input type="text" class="form-control" placeholder="请确认密码">
										<span class="help-block"></span>
									</div>
								</div>
							</div>
							<h3 class="form-section">分配角色</h3>
							<div class="row">
								<div class="form-group">
									<c:forEach items="${roleList}" var="role" varStatus="i">
										<div class="col-md-6">
											<label class="mt-checkbox mt-checkbox-outline">
												${role.name}
												<input type="checkbox" value="${role.id}" name="sysRoleList[${i.index}].id">
												<span></span>
											</label>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-6">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn green">保存</button>
											<button type="button" class="btn default" onclick="history.back(-1)">返回</button>
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