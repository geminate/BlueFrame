//验证 命名空间
(function () {
    GLOBAL.namespace("VALIDATE");

    $(function () {
        GLOBAL.VALIDATE.changeLanguage();
        GLOBAL.VALIDATE.initValidate();
        GLOBAL.VALIDATE.addMethod();
    });

    /**
     * 修改 验证提示信息语言
     */
    GLOBAL.VALIDATE.changeLanguage = function () {
        $.extend($.validator.messages, {
            required: "必填字段",
            remote: "请修正此字段",
            email: "请输入有效的电子邮件地址",
            url: "请输入有效的网址",
            date: "请输入有效的日期",
            dateISO: "请输入有效的日期 (YYYY-MM-DD)",
            number: "请输入有效的数字",
            digits: "只能输入数字",
            creditcard: "请输入有效的信用卡号码",
            equalTo: "你的输入不相同",
            extension: "请输入有效的后缀",
            maxlength: $.validator.format("最多可以输入 {0} 个字符"),
            minlength: $.validator.format("最少要输入 {0} 个字符"),
            rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
            range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
            max: $.validator.format("请输入不大于 {0} 的数值"),
            min: $.validator.format("请输入不小于 {0} 的数值")
        });
    };

    /**
     * 初始化 验证
     */
    GLOBAL.VALIDATE.initValidate = function () {
        GLOBAL.VALIDATE.validateForm("form[data-validate]");
    };

    /**
     * 针对 表单进行验证
     * @param formDom 表单Dom字符
     * @returns {*|jQuery} 验证对象
     */
    GLOBAL.VALIDATE.validateForm = function (formDom) {
        return GLOBAL.VALIDATE.validateJqForm($(formDom));    };

    /**
     * 针对 表单进行验证
     * @param $form 表单 Jq 对象
     * @returns {*|jQuery} 验证对象
     */
    GLOBAL.VALIDATE.validateJqForm = function ($form) {
        var ignore = ":hidden";
        var attrIgnore = $form.attr("data-validate-ignore");
        if (typeof(attrIgnore) != "undefined") {
            ignore = attrIgnore;
        }
        return $form.validate({errorClass: "error-place", ignore: ignore});
    };

    /**
     * 添加 常用 验证方法
     */
    GLOBAL.VALIDATE.addMethod = function () {

        //验证 大于0且小于100000的整数
        $.validator.addMethod("isPositiveInteger", function (value, element) {
            var isPositiveInteger = /^([0-9]*[0-9][0-9]*)$/;
            return this.optional(element) || ((value >= 0) && (value <= 99999) && isPositiveInteger.test(value));
        }, "请输入大于0,小于100000的整数");


        //验证用户名是否重复 -- 新增用户时
        $.validator.addMethod("checkUserNameExist", function (value, element) {
            var url = $(element).attr("validate-url");
            var re = false;
            var data = {};
            data[$(element).attr("name")] = $(element).val();
            $.ajax({
                url: url, type: "POST", async: false, data: data, success: function (ret) {
                    re = ret;
                }
            });
            return this.optional(element) || re;
        }, "用户名已存在");

        //验证用户名是否重复 -- 编辑用户时
        $.validator.addMethod("checkUserNameExistEdit", function (value, element) {
            if ($(element).attr("validate-oldName") != $(element).val()) {
                var url = $(element).attr("validate-url");
                var re = false;
                var data = {};
                data[$(element).attr("name")] = $(element).val();
                $.ajax({
                    url: url, type: "POST", async: false, data: data, success: function (ret) {
                        re = ret;
                    }
                });
                return this.optional(element) || re;
            } else {
                return true;
            }

        }, "用户名已存在");
    };
})();
