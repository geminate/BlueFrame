<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>权限管理 - 添加权限</sitemesh:title>

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
				<a href="${ctx}/frame/sys/sysPermission/insert">添加权限</a>
			</li>
		</ul>
	</div>

	<h3 class="page-title">
		权限管理<small>&emsp;添加权限&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>添加权限
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/sys/sysPermission/insert" class="horizontal-form" method="post">
						<div class="form-body">
							<h3 class="form-section">权限信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">上级权限</label>
										<sys:treeSelect id="parentId" name="parent.id" value="${sysPermission.parent.id}" showName="name" showValue="${sysPermission.parent.name}" url="${ctx}/frame/sys/sysPermission/treeAjax"
											cssClass="form-control" title="请选择上级权限" />
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">名称</label>
										<input name="name" type="text" class="form-control" placeholder="请输入名称">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">权限字符串</label>
										<input name="permissionStr" type="text" class="form-control" placeholder="请输入权限字符串">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">类型</label>
										<select class="form-control" name="type" id="typeSelect">
											<option value="0">菜单</option>
											<option value="1">权限</option>
										</select>
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6" id="menuTypeDiv">
									<div class="form-group">
										<label class="control-label need">菜单类型</label>
										<select class="form-control" id="menuTypeSelect">
											<option value="0">叶子菜单</option>
											<option value="1">父级菜单</option>
										</select>
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6" id="hrefDiv">
									<div class="form-group">
										<label class="control-label need">地址</label>
										<input name="href" type="text" class="form-control" placeholder="请输入地址">
										<span class="help-block"></span>
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
											<button type="button" class="btn default" onclick="window.location.href='${ctx}/frame/sys/sysPermission/list';">返回</button>
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