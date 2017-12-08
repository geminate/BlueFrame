<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<!-- 标题 -->
<sitemesh:title>首页</sitemesh:title>

<!-- 自定义 CSS -->
<sitemesh:custom_style>
</sitemesh:custom_style>

<!-- 自定义 JS -->
<sitemesh:custom_script>
</sitemesh:custom_script>

<!----------------------------------------------------------------- 以下为主体内容 -------------------------------------------------------------------->

<sitemesh:container>

	<shiro:hasRole name="role:admin">  
    	用户拥有角色 系统管理员<br />
	</shiro:hasRole>
	<shiro:hasRole name="role:simple">  
    	用户拥有角色 普通业务员<br />
	</shiro:hasRole>
	<shiro:hasRole name="role:teamleader">  
    	用户拥有角色 项目组长<br />
	</shiro:hasRole>
	<shiro:hasPermission name="0001">
		用户拥有权限0001<br />
	</shiro:hasPermission>
	<shiro:hasPermission name="0002">
		用户拥有权限0002<br />
	</shiro:hasPermission>
	<shiro:hasPermission name="0003">
		用户拥有权限0003<br />
	</shiro:hasPermission>
	<shiro:hasPermission name="0004">
		用户拥有权限0004<br />
	</shiro:hasPermission>


</sitemesh:container>