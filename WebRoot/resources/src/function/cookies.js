// 地址相关 命名空间
(function () {
    GLOBAL.namespace("COOKIE");

    GLOBAL.COOKIE.setCookie = function (name, value) {
        var Days = 30;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
    };

    GLOBAL.COOKIE.getCookie = function (name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        arr = document.cookie.match(reg);
        if (arr) {
            return unescape(arr[2]);
        }
        else {
            return null;
        }
    };

    GLOBAL.COOKIE.delCookie = function (name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = GLOBAL.COOKIE.getCookie(name);
        if (cval != null)
            document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString() + ";path=/";
    };
})();