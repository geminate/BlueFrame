//模板引擎 命名空间
(function () {
    GLOBAL.namespace("TEMPLATE");

    $(function () {
        GLOBAL.TEMPLATE.initTemplate();
    });

    /**
     * 初始化 模板引擎
     */
    GLOBAL.TEMPLATE.initTemplate = function () {
        _.templateSettings = {interpolate: /\{\{(.+?)\}\}/g};

        $("[data-temple]").each(function () {

            var $temp = $($(this).attr("data-temple"));
            var $tempTo = $($(this).attr("data-templeTo"));

            $(this).click(function () {
                var temple = $temp.html();
                var param = typeof($(this).attr("data-temple-param")) == "undefined" ? {} : JSON.parse($(this).attr("data-temple-param"));

                if (typeof($(this).attr("data-temple-count")) != "undefined") {
                    var count = parseInt($(this).attr("data-temple-count"));
                    param.count = count;
                    count++;
                    $(this).attr("data-temple-count", count);
                }

                var result = _.template(temple)(param);
                $tempTo.append(result);
            });

            $tempTo.on("click", "[data-temple-delete]", function () {
                var parentItem = $(this).attr("data-temple-delete");
                $(this).parents(parentItem).remove();
            });

        });
    };

})();
