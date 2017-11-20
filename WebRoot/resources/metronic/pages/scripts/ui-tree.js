var UITree = function() {

	var ajaxTreeSample = function() {

		$("#tree_4").jstree({
			"core" : {
				"themes" : {
					"responsive" : false
				},			
				"check_callback" : true,
				'data' : {
					'url' : function(node) {
						return ctx + '/sys/department/listData';
					}
				}
			},
			"types" : {
				"default" : {
					"icon" : "fa fa-folder icon-state-warning icon-lg"
				},
				"file" : {
					"icon" : "fa fa-file icon-state-warning icon-lg"
				}
			},
			"state" : {
				"key" : "demo3"
			},
			"plugins" : [ "dnd", "state", "types" ]
		});

	}

	return {
		init : function() {
			ajaxTreeSample();

		}
	};

}();

if (App.isAngularJsApp() === false) {
	jQuery(document).ready(function() {
		UITree.init();
	});
}