//Jquery相关 命名空间
(function () {
    GLOBAL.namespace("JQUERY");

    /**
     * Form 表单转 Json
     */
    GLOBAL.JQUERY.addSerializeObject = function ($element) {
        var o = {};
        var a = $element.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

})();
