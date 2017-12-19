<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>字典项管理 - 生成枚举类页</sitemesh:title>

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
				<a href="${ctx}/frame/sys/sysDict/genEnum">生成枚举类页</a>
			</li>
		</ul>
	</div>
	<!-- 标题 -->
	<h3 class="page-title">
		字典项管理<small>&emsp;生成枚举类页&emsp;</small>
	</h3>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>生成配置
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/sys/sysDict/genEnum" class="horizontal-form" method="post" data-validate>
						<div class="form-body">
							<h3 class="form-section">生成配置</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">生成分类</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<select name="type" class="select2 form-control">
												<option value="all">全部</option>
												<c:forEach items="${allTypeList}" var="item">
													<option ${(item eq param.type)?'selected="selected"':''} value="${item}">${item}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label need">生成包路径</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" name="path" class="form-control" value="com.blueframe.frame.eu" placeholder="请填写生成包路径">
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
											<button type="submit" class="btn green">生成</button>
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