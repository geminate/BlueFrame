//日期选择器 命名空间
(function () {
    GLOBAL.namespace("DATETIMEPICKER");

    GLOBAL.DATETIMEPICKER.initYearDayPicker = function () {
        $(".year-day-picker").datetimepicker(
            {
                language: 'zh-CN',
                weekStart: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2
            });
    };
})();
