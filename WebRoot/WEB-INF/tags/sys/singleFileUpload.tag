<%-- 单文件上传，文件随表单同步提交 --%>
<%-- 同步文件上传的上传地址为 Form表单的地址，Controller中可获取到上传文件和其他表单参数 --%>
<%-- Controller应保存文件、向文件表中插入一条数据、将主表中的附件ID字段置为附件的ID --%>
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
			required : ${(required!=null)?required:false},
			showUpload : false,
			allowedFileExtensions : <enhance:out escapeXml="false">${(allowedFileExtensions != null)?allowedFileExtensions:"null"}</enhance:out>,
			previewClass : "${(showPreview eq 'true')?'':'hidePreview'}"
		});
	}
</script>