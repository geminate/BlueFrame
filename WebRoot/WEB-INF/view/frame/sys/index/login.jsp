<%@ page trimDirectiveWhitespaces="true"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!DOCTYPE html>
<!--[if IE 9]> <html class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<head>
<%@ include file="/WEB-INF/view/include/meta.jsp"%>
<title>请登录</title>
<%@ include file="/WEB-INF/view/include/globle-css.jsp"%>
<link href="${ctxStatic}/metronic/pages/css/login-4.css" rel="stylesheet" type="text/css" />
<%@ include file="/WEB-INF/view/include/globle-js.jsp"%>
<script src="${ctxStatic}/metronic/pages/scripts/login-4.js" type="text/javascript"></script>
</head>
<body class="login">
	<div class="logo">
		<a href="index.html"> <img src="${ctxStatic}/metronic/pages/img/logo-big.png" alt="" />
		</a>
	</div>
	<div class="content">
		<form class="login-form" action="/login" method="post">
			<h3 class="form-title">请 登 录</h3>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span></span>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="input-icon">
					<i class="fa fa-user"></i>
					<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="input-icon">
					<i class="fa fa-lock"></i>
					<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password" />
				</div>
			</div>
			<div class="form-actions">
				<label class="rememberme mt-checkbox mt-checkbox-outline">
					<input type="checkbox" name="rememberMe">
					记住我<span></span>
				</label>
				<button id="loginBtn" type="button" class="btn green pull-right">登 录</button>
			</div>
		</form>
	</div>
	<div class="copyright">2017-2017 Sec.ac.cn 相关版权说明</div>
</body>
</html>