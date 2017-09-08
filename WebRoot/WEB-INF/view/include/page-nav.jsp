<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="pageNav">
	<ul id="topMenu">
		<li><a data-pjax="true" href="${ctx}/frame/sys/sysUser/list">用户管理</a></li>
		<li><a data-pjax="true" href="${ctx}/frame/gen/genTable/selectTable">代码生成</a></li>
	</ul>
</nav>
