<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<%@ attribute name="id" type="java.lang.String" required="true" description="组件ID，同一个页面 应为唯一值"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域 Name"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="隐藏域 Value"%>
<%@ attribute name="showName" type="java.lang.String" required="true" description="显示框显示的属性名"%>
<%@ attribute name="showValue" type="java.lang.String" required="true" description="显示框 Value"%>
<%@ attribute name="url" type="java.lang.String" required="true" description="数据请求地址"%>
<%@ attribute name="title" type="java.lang.String" required="true" description="placeholder 以及 弹出框标题"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="显示框的css Class"%>
<%@ attribute name="cssStyle" type="java.lang.String" required="false" description="显示框的css Style"%>

<input id="${id}Id" name="${name}" value="${value}" type="hidden">
<input id="${id}Name" value="${showValue}" type="text" class="${cssClass}" readonly="readonly" placeholder="${title}" data-toggle="modal"
	data-target="#${id}Modal">

<div class="modal fade bs-modal-sm" id="${id}Modal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">${title}</h4>
			</div>
			<div class="modal-body">
				<div id="${id}Tree" class="ztree"></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn green">确定</button>
				<button type="button" class="btn default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		var setting = {
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "parentId",
					rootPId : ""
				},
				key : {
					name : "name"
				}
			},
			callback : {
				onClick : function(event, treeId, treeNode) {

				},
				onDblClick : function(event, treeId, treeNode) {
					$("#${id}Modal").modal("hide");
					$("#${id}Id").val(treeNode.id);
					$("#${id}Name").val(treeNode["${showName}"]);
				}
			}
		};

		$("#${id}Name").click(function() {
			$.ajax({
				type : 'POST',
				dataType : "json",
				async : false,
				url : "${url}",
				data : {
					"flag" : true
				},
				error : function() {
					alert('获取数据失败');
				},
				success : function(data) {
					treeNodes = data;
					$.fn.zTree.init($("#${id}Tree"), setting, treeNodes).expandAll(true);
				}
			});
		});
	});
</script>