//提示信息框 命名空间
(function () {
    GLOBAL.namespace("TOASTR");

    /**
     * 初始化 重定向 提示信息展示
     */
    GLOBAL.TOASTR.initRedirectToastr = function () {
        if (toastrType != null && toastrType != "") {
            toastr[toastrType](toastrTitle, toastrMessage);
        }
    };

})();