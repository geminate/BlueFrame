<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>个人中心</sitemesh:title>

<!-- 自定义 CSS -->
<sitemesh:custom_style>
	<link href="${ctxStatic}/metronic/pages/css/profile.css" rel="stylesheet" type="text/css" />
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
				<a href="${ctx}/">首页</a> <i class="fa fa-angle-right"></i>
			</li>
			<li>
				<span>个人中心</span><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/userCenter">个人中心</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">个人中心</h3>
	<div class="row">
		<div class="col-md-12">
			<div class="profile-sidebar">
				<div class="portlet profile-sidebar-portlet light">
					<div class="profile-userpic">
						<img src="${ctxStatic}/img/avatar.png" class="img-responsive" alt="">
					</div>
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">${fns:getCurrentUser().name}</div>
						<div class="profile-usertitle-job">系统管理员</div>
					</div>
					<div class="profile-usermenu">
						<ul class="nav">
							<li class="active">
								<a href="${ctx}/frame/sys/userCenter"> <i class="icon-home"></i> 个人中心
								</a>
							</li>
							<li>
								<a href="${ctx}/frame/sys/account"> <i class="icon-settings"></i> 账户设定
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</sitemesh:container>