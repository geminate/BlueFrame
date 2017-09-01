// Select-2 命名空间
(function () {
    GLOBAL.namespace("SELECT2");

    $(function () {
        GLOBAL.SELECT2.initSelect2();
    });

    GLOBAL.SELECT2.initSelect2 = function () {
        $(".select2").each(function () {
            $(this).select2({
                language: "zh-CN",  //设置 提示语言
                width: "100%"
            });
        });
    };

})();
