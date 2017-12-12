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
						<div class=" number font-red">500</div>
						<div class=" details">
							<h3>系统出了点问题</h3>
							<p>
								请联系管理员修复这个问题，或稍后再尝试访问。 <br />
							</p>
							<p>
								<a href="${ctx}" class="btn red btn-outline"> 返回主页 </a> <br>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/include/page-footer.jsp"%>
</body>
</html>