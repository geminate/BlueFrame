// 树状表格 命名空间
(function () {
    GLOBAL.namespace("TREETABLE");

    /**
     * 初始化 树状表格
     */
    GLOBAL.TREETABLE.initTreeTable = function () {
        var option = {
            expandLevel: 999
        };
        $(".tree-table").treeTable(option);
    };

})();