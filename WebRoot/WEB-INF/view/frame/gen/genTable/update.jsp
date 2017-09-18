<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sitemesh:title>管理</sitemesh:title>

<sitemesh:style>
	<style></style>
</sitemesh:style>

<sitemesh:container>

	<div id="editPage" class="container ">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="page-header">业务表信息</h1>
				<div class="handle-bar"></div>
				<form action="${ctx}/frame/gen/genTable/update" method="post">
					<input type="hidden" name="id" value="${param.id}">
					<div class="form-group">
						<label for="">表名：</label>
						<span>${genTable.name}</span>
						<input type="hidden" name="name" value="${genTable.name}">
					</div>
					<div class="form-group">
						<label for="">说明：</label>
						<input type="text" name="comments" value="${genTable.comments}">
					</div>
					<div class="form-group">
						<label for="">对应类名：</label>
						<input type="text" name="className" value="${genTable.className}">
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th>列名</th>
								<th>注释</th>
								<th>数据库类型</th>
								<th>Java类型</th>
								<th>Java属性名</th>
								<th>主键</th>
								<th>可空</th>
								<th>插入</th>
								<th>编辑</th>
								<th>列表</th>
								<th>查询</th>
								<th>查询匹配方式</th>
								<th>显示表单类型</th>
								<th>字典类型</th>
								<th style="width: 63px;">排序</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${genTable.tableColumns}" var="item" varStatus="index">
								<tr>
									<input type="hidden" name="tableColumns[${index.index}].id" value="${item.id}"/>
									<input type="hidden" name="tableColumns[${index.index}].genTable.id" value="${item.genTable.id}"/>
									<input type="hidden" name="tableColumns[${index.index}].delFlag" value="0" />									
									<input type="hidden" name="tableColumns[${index.index}].name" value="${item.name}" />
									<td>${item.name}</td>
									<td>
										<input name="tableColumns[${index.index}].comments" class="form-control" type="text" value="${item.comments}">
									</td>
									<td>
										<input type="hidden" name="tableColumns[${index.index}].jdbcType" value="${item.jdbcType}" />${item.jdbcType}</td>
									<td>
										<select class="form-control" name="tableColumns[${index.index}].javaType">
											<c:forEach items="${config.javaTypeList}" var="javaType">
												<option value="${javaType.value}" ${javaType.value eq item.javaType?'selected':''}>${javaType.label}</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<input class="form-control" name="tableColumns[${index.index}].javaField" type="text" value="${item.javaField}">
									</td>
									<td>
										<input type="checkbox" name="tableColumns[${index.index}].isPk" value="1" ${item.isPk eq '1' ? 'checked' : ''} />
									</td>
									<td>
										<input type="checkbox" name="tableColumns[${index.index}].isNull" value="1" ${item.isNull eq '1' ? 'checked' : ''} />
									</td>
									<td>
										<input type="checkbox" name="tableColumns[${index.index}].isInsert" value="1" ${item.isInsert eq '1' ? 'checked' : ''} />
									</td>
									<td>
										<input type="checkbox" name="tableColumns[${index.index}].isEdit" value="1" ${item.isEdit eq '1' ? 'checked' : ''} />
									</td>
									<td>
										<input type="checkbox" name="tableColumns[${index.index}].isList" value="1" ${item.isList eq '1' ? 'checked' : ''} />
									</td>
									<td>
										<input type="checkbox" name="tableColumns[${index.index}].isQuery" value="1" ${item.isQuery eq '1' ? 'checked' : ''} />
									</td>
									<td>
										<select class="form-control" name="tableColumns[${index.index}].queryType">
											<c:forEach items="${config.queryTypeList}" var="queryType">
												<option value="${queryType.value}" ${queryType.value eq item.queryType?'selected':''}>${queryType.label}</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<select class="form-control" name="tableColumns[${index.index}].showType">
											<c:forEach items="${config.showTypeList}" var="showType">
												<option value="${showType.value}" ${showType.value eq item.showType?'selected':''}>${showType.label}</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<input class="form-control" name="tableColumns[${index.index}].dictType" type="text" value="${item.dictType}">
									</td>
									<td>
										<input class="form-control" name="tableColumns[${index.index}].sort" type="text" value="${item.sort}">
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="submit" class="btn btn-success" value="保存">
				</form>
			</div>
		</div>
	</div>
</sitemesh:container>

<sitemesh:script>

</sitemesh:script>