<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<%@ attribute name="id" type="java.lang.String" required="true" description="组件ID，同一个页面 应为唯一值"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="表单name"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="表单value"%>
<%@ attribute name="url" type="java.lang.String" required="true" description="数据请求地址"%>
<%@ attribute name="checkable" type="java.lang.String" required="true" description="是否是多选"%>
<%@ attribute name="expandAll" type="java.lang.String" required="false" description="true展开全部节点，false收起全部节点。默认全部展开"%>

<div id="${id}Tree" class="ztree"></div>
<input id="${id}TreeInput" type="hidden" name="${name}" value="">

<script type="text/javascript">
	$(function() {
		${id}init();
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
				autoCancelSelected: false
			},
			check : {
				enable : ${checkable}
			},
			callback : {
				onClick : function(event, treeId, treeNode) {

				},
				onDblClick : function(event, treeId, treeNode) {

				}
			}
		};

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
				${id}initFormSubmit();
			}
		});
	}

	function ${id}initFormSubmit() {
		$("#${id}Tree").parents("form").attr("onsubmit", "return ${id}formSubmit();");
	}

	function ${id}formSubmit() {
		var treeObj = $.fn.zTree.getZTreeObj("${id}Tree");
		if ("${checkable}" == "true") {
			var checkNodes = treeObj.getCheckedNodes(true);
			var idArray = [];
			$.each(checkNodes, function(index, value) {
				idArray.push(value.id);
			});
			$("#${id}TreeInput").val(idArray.join(","));
		} else {
			var selectNodes = treeObj.getSelectedNodes();
			if (selectNodes != null && selectNodes.length > 0) {
				$("#${id}TreeInput").val(selectNodes[0].id);
			}
		}
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
			if ("${value}" != null && "${value}" != "") {
				var valueArr = "${value}".split(",");
				$.each(valueArr, function(index, value) {
					var node = zTree.getNodeByParam("id", value);
					zTree.checkNode(node, true, false);
				});
			}
		} else {
			if ("${value}" != "") {
				var node = zTree.getNodeByParam("id", "${value}");
				zTree.selectNode(node);
			}
		}
	}
</script>