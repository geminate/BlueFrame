<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>用户管理 - 编辑用户</sitemesh:title>

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
				<a href="${ctx}/frame/sys/sysUser/list">用户管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="">编辑用户</a>
			</li>
		</ul>
	</div>
	<h3 class="page-title">
		用户管理<small>&emsp;编辑用户&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>编辑用户
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/sys/sysUser/update" class="horizontal-form" method="post" data-validate>
						<input type="hidden" name="id" value="${sysUser.id}">
						<div class="form-body">
							<h3 class="form-section">用户信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">姓名</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="name" type="text" class="form-control" placeholder="请输入姓名" value="${sysUser.name}">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">用户名</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="username" type="text" class="form-control" placeholder="请输入用户名" value="${sysUser.username}">
										</div>
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
												<input type="checkbox"
													<c:forEach items="${haveRoleList}" var="haveRole"><c:if test="${role.id eq haveRole.id}"> checked="checked" </c:if></c:forEach> value="${role.id}"
													name="sysRoleList[${i.index}].id">
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