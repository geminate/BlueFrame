<%@ page trimDirectiveWhitespaces="true"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true"%>
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
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white page-sidebar-fixed">
	<%@ include file="/WEB-INF/view/include/page-top.jsp"%>
	<div class="clearfix"></div>
	<div class="page-container">
		<%@ include file="/WEB-INF/view/include/page-left.jsp"%>
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li>
							<a href="index.html">首页</a> <i class="fa fa-angle-right"></i>
						</li>
						<li>
							<span>404</span>
						</li>
					</ul>
				</div>
				<div class="row" style="margin-top: 100px;">
					<div class="col-md-12 page-500">
						<div class="number font-yellow-lemon">404</div>
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

			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/view/include/page-footer.jsp"%>
</body>
</html>