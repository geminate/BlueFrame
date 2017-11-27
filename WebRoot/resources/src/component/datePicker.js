//日期、时间选择器 命名空间
(function () {
    GLOBAL.namespace("DATEPICKER");

    /**
     * 日期选择器 初始化
     */
    GLOBAL.DATEPICKER.initDatePicker = function () {
        $('.date-picker').datepicker({
            language: "zh-CN",
            autoclose: true,
            clearBtn: true
        });
    };

})();