//前台验证 命名空间
(function () {
    GLOBAL.namespace("VALIDATE");

    GLOBAL.VALIDATE.init = function () {
        $("form[data-validate]").each(function (index, item) {
            GLOBAL.VALIDATE.validateForm($(item));
        });
    };

    GLOBAL.VALIDATE.validateForm = function ($form) {
        return $form.validate({
            errorElement: 'span',
            errorClass: 'help-block help-block-error',
            focusInvalid: false,
            onkeyup: false,
            errorPlacement: function (error, element) { // render error placement for each input type
                var icon = $(element).parent('.input-icon').children('i');
                icon.removeClass('fa-check').addClass("fa-warning");
                icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
            },
            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').removeClass("has-success").addClass('has-error'); // set error class to the control group
            },
            unhighlight: function (element) {
            },
            success: function (label, element) {
                var icon = $(element).parent('.input-icon').children('i');
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success'); // set success class to the control group
                icon.removeClass("fa-warning").addClass("fa-check");
            },
            submitHandler: function (form) {
                $form[0].submit();
            }
        });
    };

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
            equalTo: "2次输入的密码不相同",
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
     * 添加 常用 验证方法
     */
    GLOBAL.VALIDATE.addMethod = function () {

        /**
         * 正则验证
         * 为 input[validate-pattern] 添加验证
         * 正则表达式 input[data-pattern]
         * 验证失败提示信息 input[data-pattern-info]
         */
        jQuery.validator.addMethod("validate-pattern", function (value, element) {
            var pattern = new RegExp($(element).attr("data-pattern"), "g");
            return this.optional(element) || pattern.test(value);
        }, function (value, element) {
            return $(element).attr("data-pattern-info") ? $(element).attr("data-pattern-info") : "不符合验证规则";
        });

        /**
         * 后台验证方法
         * 为 input[validate-remote] 添加验证
         * 后台地址 input[data-remote]
         * 验证失败提示信息 input[data-pattern-info]
         */
        jQuery.validator.addMethod("validate-remote", function (value, element) {
            var url = $(element).attr("data-remote");
            var params = {};
            params.propName = $(element).prop("name");
            params.value = $(element).val();
            var re = false;
            $.ajax({
                url: url, async: false, data: params, type: "post", success: function (res) {
                    re = (res.type == "success" ? true : false);
                }
            });
            return this.optional(element) || re;
        }, function (value, element) {
            return $(element).attr("data-remote-info") ? $(element).attr("data-remote-info") : "不符合后台验证规则";
        });
    };

})();