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
<title><sitemesh:write property='sitemesh:title' /></title>
<%@ include file="/WEB-INF/view/include/globle-css.jsp"%>
<sitemesh:write property='sitemesh:custom_style' />
<%@ include file="/WEB-INF/view/include/globle-js.jsp"%>
<sitemesh:write property='sitemesh:custom_script' />
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white page-sidebar-fixed">
	<%@ include file="/WEB-INF/view/include/page-top.jsp"%>
	<div class="clearfix"></div>
	<div class="page-container">
		<%@ include file="/WEB-INF/view/include/page-left.jsp"%>
		<div class="page-content-wrapper">
			<div class="page-content">
				<sitemesh:write property='sitemesh:container' />
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/view/include/page-footer.jsp"%>
</body>
</html>