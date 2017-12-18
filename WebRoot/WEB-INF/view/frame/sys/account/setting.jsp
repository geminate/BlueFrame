<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>账户设定</sitemesh:title>

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
				<a href="${ctx}/frame/sys/account">账户设定</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">账户设定</h3>

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
							<li>
								<a href="${ctx}/frame/sys/userCenter"> <i class="icon-home"></i> 个人中心
								</a>
							</li>
							<li class="active">
								<a href="${ctx}/frame/sys/account"> <i class="icon-settings"></i> 账户设定
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="profile-content">
				<div class="row">
					<div class="col-md-12">
						<div class="portlet light">
							<div class="portlet-title tabbable-line">
								<div class="caption caption-md">
									<i class="icon-globe theme-font hide"></i> <span class="caption-subject font-blue-madison bold">账户设定</span>
								</div>
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="#tab_1_1" data-toggle="tab">个人信息</a>
									</li>
									<li>
										<a href="#tab_1_2" data-toggle="tab">修改头像</a>
									</li>
									<li>
										<a href="#tab_1_3" data-toggle="tab">修改密码</a>
									</li>
								</ul>
							</div>
							<div class="portlet-body">
								<div class="tab-content">
									<div class="tab-pane active" id="tab_1_1">
										<form action="${ctx}/frame/sys/account/changeInfo" method="post" data-validate>
											<div class="form-group">
												<label class="control-label need">姓名</label>
												<div class="input-icon right">
													<i class="fa"></i>
													<input type="text" name="name" placeholder="请输入您的姓名" class="form-control required" value="${fns:getCurrentUser().name}">
												</div>
											</div>
											<div class="margiv-top-10">
												<button type="submit" class="btn green">保存修改</button>
											</div>
										</form>
									</div>
									<div class="tab-pane" id="tab_1_2">
										<p>请选择头像</p>
										<form action="${ctx}/frame/sys/account/changeAvatar" method="post" data-validate>
											<div class="form-group">
												<div class="fileinput fileinput-new" data-provides="fileinput">
													<div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
														<img src="${ctxStatic}/img/no_image.png" alt="" />
													</div>
													<div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
													<div>
														<span class="btn default btn-file"> <span class="fileinput-new"> 选择 </span> <span class="fileinput-exists"> 修改 </span> <input type="file"
																name="...">
														</span> <a href="javascript:;" class="btn default fileinput-exists" data-dismiss="fileinput"> 移除 </a>
													</div>
												</div>
											</div>
											<div class="margin-top-10">
												<button type="submit" class="btn green">保存修改</button>
											</div>
										</form>
									</div>
									<div class="tab-pane" id="tab_1_3">
										<form action="${ctx}/frame/sys/account/changePassword" method="post" data-validate>
											<div class="form-group">
												<label class="control-label need">当前密码</label>
												<div class="input-icon right">
													<i class="fa"></i>
													<input name="password" type="password" class="form-control required validate-remote" placeholder="请输入当前密码"
														data-remote="${ctx}/frame/sys/account/checkPassword" data-remote-info="密码错误">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label need">新密码</label>
												<div class="input-icon right">
													<i class="fa"></i>
													<input id="newPassword" name="newPassword" type="password" class="form-control required" placeholder="请输入新密码">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label need">重复输入新密码</label>
												<div class="input-icon right">
													<i class="fa"></i>
													<input name="repeatNewPassword" type="password" class="form-control required" placeholder="请重复输入新密码" equalTo="#newPassword">
												</div>
											</div>
											<div class="margin-top-10">
												<button type="submit" class="btn green">保存修改</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</sitemesh:container>