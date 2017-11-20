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
<!-- BEGIN META -->
<%@ include file="/WEB-INF/view/include/meta.jsp"%>
<!-- END META -->

<!-- BEGIN TITLE -->
<title><sitemesh:write property='sitemesh:title' /></title>
<!-- END TITLE -->

<!-- BEGIN GLOBAL STYLE-->
<%@ include file="/WEB-INF/view/include/style/global_mandatory_style.jsp"%>
<!-- END GLOBAL STYLE-->

<!-- BEGIN PAGE STYLE-->
<sitemesh:write property='sitemesh:page_level_plugins_style' />
<!-- END PAGE STYLE-->

<!-- BEGIN THEMES STYLE-->
<%@ include file="/WEB-INF/view/include/style/theme_global_style.jsp"%>
<!-- END THEMES STYLE-->

<!-- BEGIN THEMES STYLE-->
<%@ include file="/WEB-INF/view/include/style/theme_layout_style.jsp"%>
<!-- END THEMES STYLE-->

<!-- BEGIN PAGE STYLE-->
<link href="${ctxStatic}/build/custom.min.css" rel="stylesheet" type="text/css" />
<sitemesh:write property='sitemesh:custom_style' />
<!-- END PAGE STYLE-->

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

	<!--[if lt IE 9]>
		<script src="static/metronic/global/plugins/respond.min.js"></script>
		<script src="static/metronic/global/plugins/excanvas.min.js"></script> 
	<![endif]-->
	<!-- BEGIN GLOBAL SCRIPT-->
	<%@ include file="/WEB-INF/view/include/script/core_plugins_script.jsp"%>
	<!-- END GLOBAL SCRIPT-->

	<!-- BEGIN PAGE PLUGINS SCRIPT-->
	<sitemesh:write property='sitemesh:page_level_plugins_script' />
	<!-- END PAGE PLUGINS SCRIPT-->

	<!-- BEGIN THEMES SCRIPT-->
	<%@ include file="/WEB-INF/view/include/script/theme_global_script.jsp"%>
	<!-- END THEMES SCRIPT-->

	<!-- BEGIN PAGE SCRIPT-->
	<sitemesh:write property='sitemesh:page_level_script' />
	<!-- END PAGE SCRIPT-->

	<%@ include file="/WEB-INF/view/include/script/theme_layout_script.jsp"%>

	<!-- BEGIN PAGE SCRIPT-->
	<script src="${ctxStatic}/build/custom.min.js" type="text/javascript"></script>
	<sitemesh:write property='sitemesh:custom_script' />
	<!-- END PAGE SCRIPT-->
</body>
</html>