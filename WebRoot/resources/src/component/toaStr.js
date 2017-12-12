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
            toastr[toastrType](toastrTitle, toastrMessage);
        }
/*
        if (window.history && window.history.pushState) {
            $(window).on('popstate', function () {
                var hashLocation = location.hash;
                var hashSplit = hashLocation.split("#!/");
                var hashName = hashSplit[1];

                if (hashName !== '') {
                    var hash = window.location.hash;
                    if (hash === '') {

                        window.history.back(-1);
                    }
                }
            });
            window.history.pushState('forward', null, '#');
        }*/
    };

})();