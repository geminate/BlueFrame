<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sitemesh:title>用户管理</sitemesh:title>

<sitemesh:style>
	<style></style>
</sitemesh:style>

<sitemesh:container>
	<div id="editPage" class="container ">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="page-header">修改用户信息</h1>
				<div class="handle-bar"></div>

				<form action="${ctx}/frame/gen/genScheme/update" method="post" data-validate>
					<input type="hidden" name="id" value="${genScheme.id}">
					<div class="form-group">
						<label class="required" for="name">方案名称：</label>
						<input type="text" class="form-control required" id="name" name="name" placeholder="请输入用户名" value="${genScheme.name}">
					</div>
					<div class="form-group">
						<label class="required" for="packageName">包路径：</label>
						<input type="text" class="form-control required" id="packageName" name="packageName" placeholder="请输入用户名" value="${genScheme.packageName}">
					</div>
					<div class="form-group">
						<label class="required" for="moduleName">模块名：</label>
						<input type="text" class="form-control required" id="packageName" name="moduleName" placeholder="请输入用户名" value="${genScheme.moduleName}">
					</div>
					<div class="form-group">
						<label class="required" for="functionName">功能名：</label>
						<input type="text" class="form-control required" id="functionName" name="functionName" placeholder="请输入用户名" value="${genScheme.functionName}">
					</div>
					<div class="form-group">
						<label class="required" for="functionName">业务表：</label>
						<select name="genTable.id">
							<option>请选择</option>
							<c:forEach items="${genTables}" var="item">
								<option value="${item.id}" <c:if test="${item.id eq genScheme.genTable.id}">selected="selected"</c:if>>${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label class="required" for="functionAuth">功能作者：</label>
						<input type="text" class="form-control required" id="functionAuthor" name="functionAuthor" placeholder="请输入用户名" value="${genScheme.functionAuthor}">
					</div>
					<input type="submit" class="btn btn-success" value="提交">
					<input type="button" class="btn btn-danger" value="返回" onclick="history.back(-1)">
				</form>
			</div>
		</div>
	</div>
</sitemesh:container>

<sitemesh:script>

</sitemesh:script>