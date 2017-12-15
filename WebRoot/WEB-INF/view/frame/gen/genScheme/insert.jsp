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
											<input type="text" class="form-control required" id="name" name="name" placeholder="例如：人员表单表配置方案">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="packagePath">包路径</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="packagePath" name="packagePath" placeholder="例如：cn.ac.sec">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="modulePath">模块路径</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="modulePath" name="modulePath" placeholder="例如：personal">
										</div>
									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label" for="moduleName">模块说明</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control" id="moduleName" name="moduleName" placeholder="例如：人员管理">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label" for="entityName">对象说明</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control" id="entityName" name="entityName" placeholder="例如：人员">
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="genTable.id">业务表</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<select name="genTable.id" class="form-control required" id="genTable.id">
												<option value="">请选择</option>
												<c:forEach items="${genTables}" var="item">
													<option value="${item.id}">${item.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="moduleAuth">模块作者</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control required" id="moduleAuthor" name="moduleAuthor" placeholder="例如：hhLiu">
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