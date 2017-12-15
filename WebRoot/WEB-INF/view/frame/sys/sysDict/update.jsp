<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>字典项管理 - 编辑页</sitemesh:title>

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
				<a href="${ctx}/">首页</a> <i class="fa fa-angle-right"></i>
			</li>			
			<li>
				<a href="${ctx}/frame/sys/sysDict/list">字典项管理</a> <i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/sys/sysDict/update">编辑页</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		字典项管理<small>&emsp;编辑页&emsp;</small>
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
					<form action="${ctx}/frame/sys/sysDict/update" class="horizontal-form" method="post" data-validate>
						<input type="hidden" name="id" value="${sysDict.id}">
						<div class="form-body">
							<h3 class="form-section">角色信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">标签名</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="label" type="text" class="form-control" placeholder="请输入标签名" value="${sysDict.label}">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">数据值</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="value" type="text" class="form-control" placeholder="请输入数据值" value="${sysDict.value}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">			
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">分类</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="type" type="text" class="form-control" placeholder="请输入分类" value="${sysDict.type}">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">排序</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input name="sort" type="text" class="form-control" placeholder="请输入排序" value="${sysDict.sort}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">			
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">简介</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<textarea name="description" class="form-control" placeholder="请输入简介">${sysDict.description}</textarea>
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