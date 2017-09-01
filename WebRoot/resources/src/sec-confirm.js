//页面 DOM 操作 命名空间
(function () {
    GLOBAL.namespace("CONFIRM");

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
