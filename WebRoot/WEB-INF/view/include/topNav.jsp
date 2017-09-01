<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="topNav">
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">Word 模板管理系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<c:if test="${sessionScope.userSession.isAdmin eq '1'}">
					<ul class="nav navbar-nav">
						<li class="<c:if test="${param.topNavActive eq 'desktop'}"> active </c:if>"><a href="${ctx}/work/desktop"> 桌面 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'userManage'}"> active </c:if>"><a href="${ctx}/work/userManage"> 用户管理 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'templateManage'}"> active </c:if>"><a href="${ctx}/work/templateManage"> 模板管理 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'sealManage'}"> active </c:if>"><a href="${ctx}/work/sealManage"> 盖章管理 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'actionproInfo'}"> active </c:if>"><a href="${ctx}/work/actionproInfo"> 行动计划 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'dicitemInfo'}"> active </c:if>"><a href="${ctx}/work/dicitemInfo"> 字典项</a></li>
						<li class="<c:if test="${param.topNavActive eq 'fightInfo'}"> active </c:if>"><a href="${ctx}/work/fightInfo"> 航班</a></li>
						<li class="<c:if test="${param.topNavActive eq 'travelInfo'}"> active </c:if>"><a href="${ctx}/work/travelInfo"> 旅行社 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'hotelInfo'}"> active </c:if>"><a href="${ctx}/work/hotelInfo"> 酒店</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.userSession.isAdmin eq '0'}">
					<ul class="nav navbar-nav">
						<li class="<c:if test="${param.topNavActive eq 'desktop'}"> active </c:if>"><a href="${ctx}/work/desktop"> 桌面 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'workStudent'}"> active </c:if>"><a href="${ctx}/work/workStudent"> 学生管理 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'workSchool'}"> active </c:if>"><a href="${ctx}/work/workSchool"> 学校管理 </a></li>
						<li class="<c:if test="${param.topNavActive eq 'flowDemo'}"> active </c:if>"><a href="${ctx}/work/flowDemo"> 流程Demo </a></li>
					</ul>
				</c:if>
				<ul class="nav navbar-nav navbar-right user-info">
					<span>${sessionScope.userSession.name} |</span>
					<a href="${ctx}/logout"> 退出登录</a>
				</ul>
			</div>
		</div>
	</nav>
</div>