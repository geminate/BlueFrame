<%-- 树选择组件,在弹窗中展示树结构 --%>
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
<%@ attribute name="expandAll" type="java.lang.String" required="false" description="true展开全部节点，false收起全部节点。默认全部展开"%>
<%@ attribute name="checkable" type="java.lang.String" required="true" description="是否是多选"%>

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
				<button type="button" class="btn green confirm">确定</button>
				<button type="button" class="btn default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		${id}init();
		${id}initModalConfirm();
	});

	function ${id}init() {
		var ${id}setting = {
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
			view : {
				selectedMulti : false,
				autoCancelSelected : false
			},
			check : {
				enable : ${checkable}
			},
			callback : {
				onClick : function(event, treeId, treeNode) {

				},
				onDblClick : function(event, treeId, treeNode) {
					if ("${checkable}" == "false") {
						$("#${id}Modal").modal("hide");
						$("#${id}Id").val(treeNode.id);
						$("#${id}Name").val(treeNode["${showName}"]);
					}
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
					var zTree = $.fn.zTree.init($("#${id}Tree"), ${id}setting, treeNodes);
					${id}handleExpand(zTree);
					${id}handleSelect(zTree);
				}
			});
		});
	}

	//打开时 是否展开全部节点
	function ${id}handleExpand(zTree) {
		if ("${expandAll}" != "false") {
			zTree.expandAll(true);
		}
	}

	//打开时 默认选中节点
	function ${id}handleSelect(zTree) {
		if ("${checkable}" == "true") {
			if ($("#${id}Id").val() != null && $("#${id}Id").val() != "") {
				var valueArr = $("#${id}Id").val().split(",");
				$.each(valueArr, function(index, value) {
					var node = zTree.getNodeByParam("id", value);
					zTree.checkNode(node, true, false);
				});
			}
		} else {
			if ($("#${id}Id").val() != "") {
				var node = zTree.getNodeByParam("id", $("#${id}Id").val());
				zTree.selectNode(node);
			}
		}
	}

	// 模态框确认按钮点击事件
	function ${id}initModalConfirm() {
		$("#${id}Modal").find(".confirm").click(function() {
			var treeObj = $.fn.zTree.getZTreeObj("${id}Tree");
			if ("${checkable}" == "true") {
				var checkNodes = treeObj.getCheckedNodes(true);
				var idArray = [];
				var nameArray = [];
				$.each(checkNodes, function(index, value) {
					idArray.push(value.id);
					nameArray.push(value["${showName}"]);
				});
				$("#${id}Id").val(idArray.join(","));
				$("#${id}Name").val(nameArray.join(","));
				$("#${id}Modal").modal("hide");
			} else {
				var selectNodes = treeObj.getSelectedNodes();
				if (selectNodes != null && selectNodes.length > 0) {
					$("#${id}Id").val(selectNodes[0].id);
					$("#${id}Name").val(selectNodes[0]["${showName}"]);
				}
				$("#${id}Modal").modal("hide");
			}
		});
	}
</script>