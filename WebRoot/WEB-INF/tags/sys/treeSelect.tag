<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>


<%@ attribute name="id" type="java.lang.String" required="true" description="组件ID，同一个页面 应为唯一值"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域 Name"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="隐藏域 Value"%>
<%@ attribute name="showValue" type="java.lang.String" required="true" description="显示框 Value"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="显示框的css Class"%>
<%@ attribute name="cssStyle" type="java.lang.String" required="false" description="显示框的css Style"%>

<input id="${id}Id" name="${name}" value="${value}" type="hidden">
<input id="${id}Name" value="${showValue}" type="text" class="${cssClass}" readonly="readonly" placeholder="请选择上级菜单">

<script type="text/javascript">
	$(function() {
		$("#${id}Name").click(function() {
			alert();
		});
	});
</script>