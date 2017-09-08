<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!(PJAX eq '1')}">

	<!DOCTYPE html>
	<html>
		<head>
		<title><sitemesh:write property='sitemesh:title' /></title>
		<%@ include file="/WEB-INF/view/include/link.jsp"%>
		<sitemesh:write property='sitemesh:style' />
		</head>
		<body>
			<!--start: 页面头部 -->
			<%@ include file="/WEB-INF/view/include/page-head.jsp"%>
			<!--end: 页面头部 -->
		
			<!--start: 顶部导航 -->
			<%@ include file="/WEB-INF/view/include/page-nav.jsp"%>
			<!--end: 顶部导航 -->
		
			<!--start: 左侧导航 -->
			<%@ include file="/WEB-INF/view/include/page-left.jsp"%>
			<!--end: 左侧导航 -->
		
			<!--start: 内容主体 -->
			<div id="pageContainer">
				<div id="innerContainer">
					<sitemesh:write property='sitemesh:container' />
				</div>
			</div>
			<!--end: 内容主体 -->
		
			<%@ include file="/WEB-INF/view/include/script.jsp"%>
			<sitemesh:write property='sitemesh:script' />
		</body>
	</html>

</c:if>

<c:if test="${(PJAX eq '1')}">
	<sitemesh:write property='sitemesh:container' />
	<sitemesh:write property='sitemesh:script' />
</c:if>