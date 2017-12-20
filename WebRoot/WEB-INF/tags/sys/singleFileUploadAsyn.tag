<%-- 单文件上传，文件异步提交 --%>
<%-- 异步上传的地址为 /sys/sysFile/uploadFile,上传完成后会异步返回上传的附件ID，并作为一个隐藏字段最终通过表单提交 --%>
<%-- Controller中应将主表中的附件ID字段置为附件的ID，并更新附件表修改器附件类型与外键ID --%>
<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<%@ attribute name="id" type="java.lang.String" required="true" description="组件ID，同一个页面 应为唯一值"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="表单name"%>
<%@ attribute name="description" type="java.lang.String" required="true" description="字段说明，例如:头像"%>
<%@ attribute name="showPreview" type="java.lang.String" required="false" description="是否显示缩略图,默认不显示"%>
<%@ attribute name="showDropZone" type="java.lang.String" required="false" description="是否显示拖拽区,默认不显示"%>
<%@ attribute name="required" type="java.lang.String" required="false" description="是否必填"%>
<%@ attribute name="maxFilePreviewSize" type="java.lang.String" required="false" description="文件大小限制,默认25600 即 25M"%>
<%@ attribute name="allowedFileExtensions" type="java.lang.String" required="false" description="允许的文件类型，默认全部类型"%>

<input id="${id}FileInput" type="file" name="${id}File">
<input id="${id}ValueInput" type="hidden" name="${name}" value="">

<script type="text/javascript">
	var ${id}FileUploading = false;

	$(function() {
		init${id}FileUpload();// 初始化上传配置
		init${id}UploadEvent();
		init${id}FormSubmit();
	});

	function init${id}FileUpload() {
		$("#${id}FileInput").fileinput({
			language : 'zh',// 语言
			showClose : false,// 是否显示 关闭按钮
			allowedPreviewTypes : [ 'image' ],
			required : ${(required!=null)?required:false},
			allowedFileExtensions : <enhance:out escapeXml="false">${(allowedFileExtensions != null)?allowedFileExtensions:"null"}</enhance:out>,
			previewClass : "${(showPreview eq 'true')?'':'hidePreview'}",
			dropZoneEnabled : ${(showDropZone!=null)?showDropZone:false},
			uploadUrl : "${ctx}/frame/sys/sysFile/uploadFile"
		});
	}

	function init${id}UploadEvent() {
		$("#${id}FileInput").on("filepreupload", function(event, data, previewId, index) {
			${id}FileUploading = true;
		});
		$("#${id}FileInput").on("fileuploaded", function(event, data, previewId, index) {
			${id}FileUploading = false;
			$("#${id}ValueInput").val(data.response.message);
		});
		$("#${id}FileInput").on("fileuploaderror", function(event, data, msg) {
			${id}FileUploading = false;
		});
		$("#${id}FileInput").on("filepreremove", function(event, id, index) {
			$("#${id}ValueInput").val("");
		});
		$("#${id}FileInput").on("filebeforedelete", function(event, key, data) {
			$("#${id}ValueInput").val("");
		});
		$("#${id}FileInput").on("fileclear", function(event) {
			$("#${id}ValueInput").val("");
		});
		$("#${id}FileInput").on("filereset", function(event) {
			$("#${id}ValueInput").val("");
		});
	}

	function init${id}FormSubmit() {
		$("#${id}FileInput").parents("form").attr("onsubmit", "return ${id}formSubmit();");
	}

	function ${id}formSubmit() {
		var filesCount = $("#${id}FileInput").fileinput("getFilesCount");
		if ($("#${id}ValueInput").val() == "" && ${(required!=null)?required:false}) { // 必填且无返回ID			
			if (filesCount == 0) {
				toastr["warning"]("${description}字段为必填字段", "请检查");
				return false;
			} else if (${id}FileUploading) {
				toastr["warning"]("请等待${description}文件上传完成", "请等待");
				return false;
			} else {
				toastr["warning"]("请先开始${description}文件的上传", "请检查");
				return false;
			}
		} else {
			if (filesCount > 0) {
				toastr["warning"]("请先开始${description}文件的上传", "请检查");
				return false;
			} else {
				return true;
			}
		}
	}
</script>