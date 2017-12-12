<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>权限管理 - 编辑权限</sitemesh:title>

<!-- 自定义 CSS -->
<sitemesh:custom_style>
</sitemesh:custom_style>

<!-- 自定义 JS -->
<sitemesh:custom_script>
	<script>
		$(function() {
			initListener();
			refreshTypeSelect();
		});

		function initListener() {
			$("#typeSelect").change(function() {
				refreshTypeSelect();
			});

			$("#menuTypeSelect").change(function() {
				refreshTypeSelect();
			});
		}

		function refreshTypeSelect() {
			if ($("#typeSelect").val() == "0") {
				$("#menuTypeDiv").show();
				if ($("#menuTypeSelect").val() == 0) {
					$("#hrefDiv").show();
				} else {
					$("#hrefDiv").val();
					$("#hrefDiv").hide();
				}
			} else {
				$("#menuTypeDiv").hide();
				$("#hrefDiv").hide();
				$("#hrefDiv").val();
			}
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
				<a href="">编辑权限</a>
			</li>
		</ul>
	</div>
	<h3 class="page-title">
		权限管理<small>&emsp;编辑权限&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>编辑权限
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/sys/sysPermission/update" class="horizontal-form" method="post" data-validate>
						<input type="hidden" name="id" value="${sysPermission.id}">
						<div class="form-body">
							<h3 class="form-section">权限信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">上级权限</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<sys:treeSelectModal checkable="false" id="parentId" name="parent.id" value="${sysPermission.parent.id}" showName="name"
												showValue="${sysPermission.parent.name}" url="${ctx}/frame/sys/sysPermission/treeAjax" cssClass="form-control" title="请选择上级权限" expandAll="true" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">名称</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="name" type="text" class="form-control required" maxlength="20" placeholder="请输入名称" value="${sysPermission.name}">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">权限字符串</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="permissionStr" type="text" class="form-control" placeholder="请输入权限字符串" value="${sysPermission.permissionStr}">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">类型</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<select class="form-control" name="type" id="typeSelect">
												<option value="0" <c:if test="${sysPermission.type eq '0'}">selected="selected"</c:if>>菜单</option>
												<option value="1" <c:if test="${sysPermission.type eq '1'}">selected="selected"</c:if>>权限</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6" id="menuTypeDiv">
									<div class="form-group">
										<label class="control-label need">菜单类型</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<select class="form-control" id="menuTypeSelect">
												<option value="0" <c:if test="${not empty sysPermission.href}">selected="selected"</c:if>>叶子菜单</option>
												<option value="1" <c:if test="${empty sysPermission.href}">selected="selected"</c:if>>父级菜单</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6" id="hrefDiv">
									<div class="form-group">
										<label class="control-label need">地址</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="href" type="text" class="form-control required" maxlength="500" placeholder="请输入地址" value="${sysPermission.href}">
										</div>
									</div>
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