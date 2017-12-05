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
<title>404 未找到</title>
<%@ include file="/WEB-INF/view/include/globle-css.jsp"%>
<link href="${ctxStatic}/metronic/pages/css/error.css" rel="stylesheet" type="text/css" />
<%@ include file="/WEB-INF/view/include/globle-js.jsp"%>
</head>
<body class="page-500-full-page">
	<div class="row">
		<div class="col-md-12 page-500">
			<div class="number font-yellow-lemon">400</div>
			<div class="details">
				<h3>页面不存在</h3>
				<p>
					您要查找的页面可能已被删除，已更改名称或者暂时不可用。 <br />
				</p>
				<p>
					<a href="${ctx}" class="btn yellow-lemon btn-outline"> 返回主页 </a> <br>
				</p>
			</div>
		</div>
	</div>
</body>
</html>