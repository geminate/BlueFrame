<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>菜单管理 - 添加菜单</sitemesh:title>

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
				<a href="${ctx}/frame/sys/sysMenu/list">菜单管理</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysMenu/insert">添加菜单</a>
			</li>
		</ul>
	</div>

	<h3 class="page-title">
		菜单管理<small>&emsp;添加菜单&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>添加菜单
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/sys/sysMenu/insert" class="horizontal-form" method="post">
						<div class="form-body">
							<h3 class="form-section">菜单信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">上级菜单</label>
										<sys:treeSelect id="parentId" name="parent.id" value="" showValue="" cssClass="form-control" />
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
										<label class="control-label need">地址</label>
										<input name="href" type="text" class="form-control" placeholder="请输入地址">
										<span class="help-block"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">权限字符串</label>
										<input name="pemissionStr" type="text" class="form-control" placeholder="请输入权限字符串">
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