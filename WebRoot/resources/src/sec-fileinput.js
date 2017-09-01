//附件上传 命名空间
(function () {
    GLOBAL.namespace("FILEINPUT");

    $(function () {

    });

    /**
     * 文件上传 初始化
     * @param dom input[type=file] dom字符
     * @param url 上传路径
     * @param fileCount 上传文件最大数量
     * @param ajaxData 附加数据
     * @param allowType 允许的文件格式
     */
    GLOBAL.FILEINPUT.initFileInput = function (dom, url, fileCount, ajaxData, allowType, showUpload) {
        $(dom).fileinput(
            {
                dropZoneEnabled: false,
                uploadUrl: url,
                uploadAsync: true,
                autoReplace: true,
                maxFileCount: fileCount,
                uploadExtraData: function (previewId, index) {
                    return ajaxData;
                },
                allowedFileExtensions: allowType,
                showUpload: showUpload
            });
    };

    /**
     *  上传图片的 图片回显
     * @param dom input[type=file] dom字符
     * @param imgDom img dom字符
     * @param imgUrl 图片根目录地址
     * @param nameProp 上传完成 后台返回的 Json 属性
     */
    GLOBAL.FILEINPUT.initFileInputImg = function (dom, imgDom, imgUrl, nameProp) {
        $(dom).on("fileuploaded", function (event, data, previewId, index) {
            $(imgDom).attr("src", imgUrl + data.response[nameProp]);
            $(dom).fileinput("refresh");
            $(dom).fileinput("enable");
        });
    };

    /**
     * Form 表单中的 文件上传：如果需要将附件上传后的返回值加入表单，需要让表单中隐藏域的name与附件上传返回值的属性一一对应
     * @param fileInputDom input[type=file] dom字符
     * @param formDom 表单 dom字符
     * @param submitBtnDom 提交按钮 dom字符
     */
    GLOBAL.FILEINPUT.initFileInputForm = function (fileInputDom, formDom, submitBtnDom) {
        $(submitBtnDom).click(function () {
            if (GLOBAL.VALIDATE.validateForm(formDom).form()) {
                $(fileInputDom).fileinput("upload");
            }
        });

        $(fileInputDom).on("fileuploaded", function (event, data, previewId, index) {
            for (var key in data.response) {
                $(formDom).find("[name=" + key + "]").val(data.response[key]);
            }
            $(formDom)[0].submit();
        });
    };

})();
