<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>生成方案配置 - 添加生成方案</sitemesh:title>

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
				<span>代码生成</span><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/gen/genScheme">生成方案配置</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="">添加生成方案</a>
			</li>
		</ul>
	</div>

	<h3 class="page-title">
		生成方案配置<small>&emsp;添加生成方案&emsp;</small>
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
					<form action="${ctx}/frame/gen/genScheme/insert" method="post" class="horizontal-form" data-validate>
						<div class="form-body">
							<h3 class="form-section">权限信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="name">方案名称</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="name" name="name" placeholder="请输入方案名称">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="packageName">包路径</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="packageName" name="packageName" placeholder="请输入包路径">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="moduleName">模块名</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="packageName" name="moduleName" placeholder="请输入模块名">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="functionName">功能名</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="functionName" name="functionName" placeholder="请输入功能名">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="functionName">业务表</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<select name="genTable.id" class="form-control">
												<option>请选择</option>
												<c:forEach items="${genTables}" var="item">
													<option value="${item.id}">${item.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="functionAuth">功能作者</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="functionAuthor" name="functionAuthor" placeholder="请输入功能作者">
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