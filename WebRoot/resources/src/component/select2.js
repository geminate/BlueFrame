//下拉框 命名空间
(function () {
    GLOBAL.namespace("SELECT2");

    GLOBAL.SELECT2.initSelect2 = function () {
        $.fn.select2.defaults.set("theme", "bootstrap");
        $(".select2, .select2-multiple").select2({
            placeholder: '请选择',
            width: null,
            escapeMarkup: function (markup) {
                return markup;
            },
            templateResult: GLOBAL.SELECT2.temple,
            templateSelection: GLOBAL.SELECT2.temple
        });

        $(".select2-allow-clear").select2({
            allowClear: true,
            placeholder: '请选择',
            width: null,
            escapeMarkup: function (markup) {
                return markup;
            },
            templateResult: GLOBAL.SELECT2.temple,
            templateSelection: GLOBAL.SELECT2.temple
        });
    };

    GLOBAL.SELECT2.temple = function (item) {
        var re = item.text;
        if ($(item.element).attr("data-subtext")) {
            re = re + "<small class='text-muted'>" + $(item.element).attr("data-subtext") + "</small>";
        }
        return re;
    };

})();