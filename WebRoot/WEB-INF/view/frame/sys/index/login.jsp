<%@ page trimDirectiveWhitespaces="true"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!DOCTYPE html>
<!--[if IE 8]> <html class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>请登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta content="width=device-width, initial-scale=1" name="viewport" />
<script type="text/javascript">
	var ctx = '${ctx}', ctxStatic = '${ctxStatic}';
</script>
<%@ include file="/WEB-INF/view/include/style/global_mandatory_style.jsp"%>

<link href="${ctxStatic}/metronic/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/metronic/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />

<%@ include file="/WEB-INF/view/include/style/theme_global_style.jsp"%>
<%@ include file="/WEB-INF/view/include/style/theme_layout_style.jsp"%>

<link href="${ctxStatic}/metronic/pages/css/login-4.css" rel="stylesheet" type="text/css" />
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
				<button id="loginBtn" type="button" class="btn green pull-right">登 录</button>
			</div>
		</form>
	</div>

	<div class="copyright">2017-2017 Sec.ac.cn 相关版权说明</div>
	<!--[if lt IE 9]>
		<script src="static/metronic/global/plugins/respond.min.js"></script>
		<script src="static/metronic/global/plugins/excanvas.min.js"></script> 
	<![endif]-->
	<%@ include file="/WEB-INF/view/include/script/core_plugins_script.jsp"%>

	<script src="${ctxStatic}/metronic/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/metronic/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/metronic/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/metronic/global/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>

	<%@ include file="/WEB-INF/view/include/script/theme_global_script.jsp"%>

	<script src="${ctxStatic}/metronic/pages/scripts/login-4.js" type="text/javascript"></script>
	
	<%@ include file="/WEB-INF/view/include/script/theme_layout_script.jsp"%>
</body>
</html>