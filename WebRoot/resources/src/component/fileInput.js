//文件上传 命名空间
(function () {
    GLOBAL.namespace("FILEINPUT");


    GLOBAL.FILEINPUT.initFileInput = function () {
        $("input[single-upload]").each(function () {
            $(this).fileinput({
                language: 'zh',
                allowedPreviewTypes: ['image']
            });
        });
    };

})();