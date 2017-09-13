<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sitemesh:title>用户管理</sitemesh:title>

<sitemesh:style>
	<style></style>
</sitemesh:style>

<sitemesh:container>
	<div id="listPage" class="container ">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="page-header">业务表列表</h1>
				<form class="form-inline search-form" id="search-form" style="overflow: auto;">					
					<div class="col-sm-4 search-form-btnDiv">						
						<a data-pjax="true" class="btn btn-primary" href="${ctx}/frame/gen/genTable/selectTable">新增</a>
					</div>
				</form>
				<hr>				
			</div>
		</div>
	</div>
</sitemesh:container>

<sitemesh:script>
	
</sitemesh:script>