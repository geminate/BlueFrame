// 地址相关 命名空间
(function () {
    GLOBAL.namespace("FORM");

    GLOBAL.FORM.initResetBtn = function () {
        $(".reset-btn").click(function () {
            var $form = $(this).parents("form");
            $form.find(":input").not(':button,:submit,:reset,:hidden').val('').removeAttr('checked').removeAttr('selected');
            $form[0].submit();
        });
    };
})();