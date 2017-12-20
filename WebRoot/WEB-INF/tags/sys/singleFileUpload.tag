<%-- 单文件上传，文件随表单同步提交 --%>
<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<%@ attribute name="id" type="java.lang.String" required="true" description="组件ID，同一个页面 应为唯一值"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="表单name"%>
<%@ attribute name="showPreview" type="java.lang.String" required="false" description="是否显示缩略图,默认不显示"%>
<%@ attribute name="required" type="java.lang.String" required="false" description="是否必填"%>
<%@ attribute name="maxFilePreviewSize" type="java.lang.String" required="false" description="文件大小限制,默认25600 即 25M"%>
<%@ attribute name="allowedFileExtensions" type="java.lang.String" required="false" description="允许的文件类型，默认全部类型"%>

<input id="${id}FileInput" type="file" name="${name}">

<script type="text/javascript">
	$(function() {
		init${id}FileUpload();// 初始化上传配置
	});

	function init${id}FileUpload() {
		$("#${id}FileInput").fileinput({
			language : 'zh',// 语言
			showClose : false,// 是否显示 关闭按钮
			allowedPreviewTypes : [ 'image' ],
			required : ${required?required:false},
			showUpload : false,
			allowedFileExtensions : <enhance:out escapeXml="false">${allowedFileExtensions?allowedFileExtensions:"null"}</enhance:out>,
			previewClass : "${(showPreview eq 'true')?'':'hidePreview'}"
		});
	}
</script>