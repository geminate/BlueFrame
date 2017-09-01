//Jquery-Confirm 命名空间
(function () {

    GLOBAL.namespace("CONFIRM");

    /**
     * 显示提示信息
     * @param text 信息主体内容
     * @param color 信息颜色
     * @param callback 点击确定后的回调
     */
    GLOBAL.CONFIRM.alert = function (text, color, callback) {
        $.alert(
            {
                title: text,
                type: color,
                backgroundDismiss: true,
                content: "",
                onClose: function () {
                    callback();
                }
            });
    };
})();
