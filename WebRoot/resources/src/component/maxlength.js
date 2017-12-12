// 输入框长度提示 命名空间
(function () {
    GLOBAL.namespace("MAXLENGTH");

    GLOBAL.MAXLENGTH.init = function () {
        $("input[maxlength]").not("[no-maxlength]").maxlength({
            limitReachedClass: "label label-danger"
        });
    };

})();