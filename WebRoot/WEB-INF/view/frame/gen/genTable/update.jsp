<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>业务表配置 - 编辑业务表信息</sitemesh:title>

<!-- 自定义 CSS -->
<sitemesh:custom_style>
	<style>
.table td,.table th {
	font-size: 12px;
}
</style>
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
				<a href="">编辑业务表</a>
			</li>
		</ul>
	</div>
	<h3 class="page-title">
		业务表配置<small>&emsp;编辑业务表&emsp;</small>
	</h3>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-user"></i>编辑业务表
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" title="收起/打开"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${ctx}/frame/gen/genTable/update" method="post" class="horizontal-form" data-validate>
						<div class="form-body">
							<h3 class="form-section">业务表信息</h3>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label need" for="name">表名</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input readonly="readonly" ="text" class="form-control" name="name" value="${genTable.name}">
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label need" for="name">对应类名</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control" name="className" value="${genTable.className}">
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label need" for="name">说明</label>
										<div class="input-icon right">
											<i class="fa"></i>
											<input type="text" class="form-control" name="comments" value="${genTable.comments}">
										</div>
									</div>
								</div>
							</div>
							<h3 class="form-section">列信息</h3>
							<div class="row">
								<div class="col-md-12">
									<div class="table-scrollable">
										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th style="min-width: 130px;">列名</th>
													<th style="min-width: 90px;">注释</th>
													<th style="min-width: 90px;">数据库类型</th>
													<th style="min-width: 105px;">Java类型</th>
													<th>Java属性名</th>
													<th>K</th>
													<th>空</th>
													<th>增</th>
													<th>改</th>
													<th>表</th>
													<th>查</th>
													<th style="min-width: 110px;">查询方式</th>
													<th style="min-width: 110px;">显示表单类型</th>
													<th style="min-width: 90px;">字典类型</th>
													<th style="min-width: 60px;">排序</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${genTable.tableColumns}" var="item" varStatus="index">
													<tr>
														<input type="hidden" name="tableColumns[${index.index}].id" value="${item.id}" />
														<input type="hidden" name="tableColumns[${index.index}].genTable.id" value="${item.genTable.id}" />
														<input type="hidden" name="tableColumns[${index.index}].delFlag" value="0" />
														<input type="hidden" name="tableColumns[${index.index}].name" value="${item.name}" />
														<td style="word-break: break-word;">${item.name}</td>
														<td>
															<input name="tableColumns[${index.index}].comments" class="form-control input-sm" type="text" value="${item.comments}">
														</td>
														<td>
															<input type="hidden" name="tableColumns[${index.index}].jdbcType" value="${item.jdbcType}" />${item.jdbcType}</td>
														<td>
															<select class="form-control input-sm" name="tableColumns[${index.index}].javaType">
																<c:forEach items="${config.javaTypeList}" var="javaType">
																	<option value="${javaType.value}" ${javaType.value eq item.javaType?'selected':''}>${javaType.label}</option>
																</c:forEach>
															</select>
														</td>
														<td>
															<input class="form-control input-sm" name="tableColumns[${index.index}].javaField" type="text" value="${item.javaField}">
														</td>
														<td>
															<label class="mt-checkbox mt-checkbox-outline table-checkbox">
																<input type="checkbox" name="tableColumns[${index.index}].isPk" value="1" ${item.isPk eq '1' ? 'checked' : ''} />
																<span></span>
															</label>
														</td>
														<td>
															<label class="mt-checkbox mt-checkbox-outline table-checkbox">
																<input type="checkbox" name="tableColumns[${index.index}].isNull" value="1" ${item.isNull eq '1' ? 'checked' : ''} />
																<span></span>
															</label>
														</td>
														<td>
															<label class="mt-checkbox mt-checkbox-outline table-checkbox">
																<input type="checkbox" name="tableColumns[${index.index}].isInsert" value="1" ${item.isInsert eq '1' ? 'checked' : ''} />
																<span></span>
															</label>
														</td>
														<td>
															<label class="mt-checkbox mt-checkbox-outline table-checkbox">
																<input type="checkbox" name="tableColumns[${index.index}].isEdit" value="1" ${item.isEdit eq '1' ? 'checked' : ''} />
																<span></span>
															</label>
														</td>
														<td>
															<label class="mt-checkbox mt-checkbox-outline table-checkbox">
																<input type="checkbox" name="tableColumns[${index.index}].isList" value="1" ${item.isList eq '1' ? 'checked' : ''} />
																<span></span>
															</label>
														</td>
														<td>
															<label class="mt-checkbox mt-checkbox-outline table-checkbox">
																<input type="checkbox" name="tableColumns[${index.index}].isQuery" value="1" ${item.isQuery eq '1' ? 'checked' : ''} />
																<span></span>
															</label>
														</td>
														<td>
															<select class="form-control input-sm" name="tableColumns[${index.index}].queryType">
																<c:forEach items="${config.queryTypeList}" var="queryType">
																	<option value="${queryType.value}" ${queryType.value eq item.queryType?'selected':''}>${queryType.label}</option>
																</c:forEach>
															</select>
														</td>
														<td>
															<select class="form-control input-sm" name="tableColumns[${index.index}].showType">
																<c:forEach items="${config.showTypeList}" var="showType">
																	<option value="${showType.value}" ${showType.value eq item.showType?'selected':''}>${showType.label}</option>
																</c:forEach>
															</select>
														</td>
														<td>
															<input class="form-control input-sm" name="tableColumns[${index.index}].dictType" type="text" value="${item.dictType}">
														</td>
														<td>
															<input class="form-control input-sm" name="tableColumns[${index.index}].sort" type="text" value="${item.sort}">
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
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