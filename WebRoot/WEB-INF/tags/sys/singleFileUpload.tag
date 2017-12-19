<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<%@ attribute name="id" type="java.lang.String" required="true" description="组件ID，同一个页面 应为唯一值"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="表单name"%>
<%@ attribute name="required" type="java.lang.String" required="false" description="是否必选"%>
<%@ attribute name="showPreview" type="java.lang.String" required="false" description="是否显示缩略图,默认不显示"%>

<input id="${id}" type="file" name="${name}" single-upload>

<script type="text/javascript">
	$("#${id}").fileinput({
		language : 'zh',
		required : ${required?required:false},
		allowedPreviewTypes : [ 'image' ],
		showPreview : ${showPreview?showPreview:false},
		showClose : false,
		uploadUrl : "${ctx}/frame/sys/account"
	});
</script>