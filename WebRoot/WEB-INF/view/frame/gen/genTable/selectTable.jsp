<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sitemesh:title>管理</sitemesh:title>

<sitemesh:style>
	<style></style>
</sitemesh:style>

<sitemesh:container>

	<form data-pjax="true" action="${ctx}/frame/gen/genTable/selectTableColumn">
		<select name="name">
			<c:forEach items="${tableList}" var="item">
				<option value="${item.name}">${item.name}<c:if test="${not (empty item.comments)}"> ------ ${item.comments}</c:if></option>
			</c:forEach>
		</select>
		<input type="submit">
	</form>
</sitemesh:container>

<sitemesh:script>

</sitemesh:script>