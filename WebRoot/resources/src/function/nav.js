// 导航相关 命名空间
(function () {
    GLOBAL.namespace("NAV");

    GLOBAL.NAV.initNAVSelect = function () {
        var location = window.location.href;
        $(".page-sidebar-menu li").each(function () {
            var href = $(this).children("a").attr("href");
            if (location.indexOf(href) != -1) {
                $(this).addClass("active open");
                $(this).children("a").children(".arrow").addClass("open");

                $(this).parents("li").each(function () {
                    $(this).addClass("active open");
                    $(this).children("a").children(".arrow").addClass("open");
                });
            }
        });
    };

    GLOBAL.NAV.initRememberStatus = function () {
        $(".menu-toggler").click(function () {
            if ($("body").hasClass("page-sidebar-closed")) {
                GLOBAL.COOKIE.delCookie("navStatus");
            } else {
                GLOBAL.COOKIE.setCookie("navStatus", "close");
            }
        });

        if (GLOBAL.COOKIE.getCookie("navStatus") != null) {
            $("body").addClass("page-sidebar-closed");
            $(".page-sidebar-menu").addClass("page-sidebar-menu-closed");
        }
    };

})();