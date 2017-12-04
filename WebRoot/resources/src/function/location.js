// 地址相关 命名空间
(function () {
    GLOBAL.namespace("LOCATION");

    GLOBAL.LOCATION.back = function () {
        window.history.back();
        toastrType = "";
    };
})();