<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>错误页面</title>

<script>
	
</script>
</head>

<body>
	<h1>出错了</h1>
	<%
		Exception e = (Exception) request.getAttribute("exception");
		out.print(e.getMessage());
	%>
</body>
</html>