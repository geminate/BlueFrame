//页面 DOM 操作 命名空间
(function () {
    GLOBAL.namespace("DOM");

    GLOBAL.DOM.initPjax = function () {
        $(document).pjax('a[data-pjax]', '#innerContainer');
        $(document).on('pjax:complete', function () {
            initPageBind();
        });
    };

    GLOBAL.DOM.toggleDisable = function ($ele) {
        if ($ele.attr("disabled") == "disabled") {
            $ele.removeAttr("disabled");
        } else {
            $ele.attr("disabled", "disabled");
        }
    };

    GLOBAL.DOM.toggleDisableSaveBtn = function ($ele) {
        if ($ele.attr("disabled") == "disabled") {
            $ele.removeAttr("disabled");
            $ele.val("保存");
        } else {
            $ele.attr("disabled", "disabled");
            $ele.val("保存中...");
        }
    };

    GLOBAL.DOM.toggleDisableSubmitBtn = function ($ele) {
        if ($ele.attr("disabled") == "disabled") {
            $ele.removeAttr("disabled");
            $ele.val("提交");
        } else {
            $ele.attr("disabled", "disabled");
            $ele.val("提交中...");
        }
    };

})();
