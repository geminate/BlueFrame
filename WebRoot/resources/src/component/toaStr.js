//提示信息框 命名空间
(function () {
    GLOBAL.namespace("TOASTR");

    /**
     * 初始化 重定向 提示信息展示
     */
    GLOBAL.TOASTR.initRedirectToastr = function () {
        toastr.options = {
            closeButton: true
        };

        if (toastrType != null && toastrType != "" && window.name == "") {
            toastr[toastrType](toastrMessage, toastrTitle);
        }

    };

})();