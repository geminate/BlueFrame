<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>请登录</title>
<%@ include file="/WEB-INF/view/include/link.jsp"%>
</head>
<body>
	<div id="login">
		<div class="container">
			<form class="form-signin" action="${ctx}/login" method="post">
				<h2 class="form-signin-heading">请登录</h2>
				<input class="form-control" name="username" id="username" placeholder="用户名" type="text">
				<input class="form-control" name="password" id="password" placeholder="密码" type="password">
				<c:if test="${not(empty loginFail)}">
					<span class="login-error">用户名密码错误</span>
				</c:if>
				<input class="btn btn-lg btn-primary btn-block" type="submit" value="登录">
			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/view/include/script.jsp"%>
</body>
</html>