//Jquery-Confirm 命名空间
(function () {

    GLOBAL.namespace("PJAX");

    //ajax 计数器，用于定期清理浏览器 内存占用
    GLOBAL.PJAX.refreshCount = 0;

    GLOBAL.PJAX.initPjax = function () {

        $(document).pjax('a[data-pjax]', '#innerContainer');

        $(document).on('pjax:complete', function () {
            GLOBAL.PJAX.refreshCount++;
            if (GLOBAL.PJAX.refreshCount >= 250) {
                window.location.reload();
            }
            initPageBind();
        });

    };
})();
