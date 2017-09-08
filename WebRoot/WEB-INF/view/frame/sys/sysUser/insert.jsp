<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sitemesh:title>用户管理</sitemesh:title>

<sitemesh:style>
	<style></style>
</sitemesh:style>

<sitemesh:container>
	<div id="editPage" class="container ">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="page-header">添加用户信息</h1>
				<div class="handle-bar"></div>

				<form action="${ctx}/frame/sys/sysUser/insert" method="post" data-validate>
					<div class="form-group">
						<label class="required" for="username">用户名：</label>
						<input type="text" class="form-control required" id="username" name="username" placeholder="请输入用户名">
					</div>
					<input type="submit" class="btn btn-success" value="提交">
					<input type="button" class="btn btn-danger" value="返回" onclick="history.back(-1)">
				</form>
			</div>
		</div>
	</div>
</sitemesh:container>

<sitemesh:script>
	
</sitemesh:script>