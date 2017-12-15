<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>业务表配置 - 选择业务表</sitemesh:title>

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
				<a href="${ctx}/frame/gen/genTable">业务表配置</a><i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="${ctx}/frame/gen/genTable/selectTable">选择业务表</a>
			</li>
		</ul>
	</div>

	<h3 class="page-title">
		业务表配置<small>&emsp;选择业务表&emsp;</small>
	</h3>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>选择业务表
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/gen/genTable/insert" method="get" class="horizontal-form" data-validate>
						<div class="form-body">
							<h3 class="form-section">选择业务表</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need" for="name">业务表</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<select class="select2 form-control required" name="name" size="20">
												<c:forEach items="${tableList}" var="item">
													<option data-subtext="${item.comments}" value="${item.name}">${item.name}</option>
												</c:forEach>
											</select>
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