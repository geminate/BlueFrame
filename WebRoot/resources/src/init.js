//定义全局 命名空间
var GLOBAL = {};
GLOBAL.namespace = function (str) {
    var arr = str.split(".");
    var o = GLOBAL;
    var i = (arr[0] == "GLOBAL" ? 1 : 0);
    for (; i < arr.length; i++) {
        o[arr[i]] = o[arr[i]] || {};
        o = o[arr[i]];
    }
};

$(function () {
    init();

});

function init() {

    //初始化 Pjax :
    GLOBAL.DOM.initPjax();
    //为 Validtae 验证 添加规则
    GLOBAL.VALIDATE.addMethod();
    //修改 Validate 语言
    GLOBAL.VALIDATE.changeLanguage();
    //初始化 事件绑定
    initPageBind();
}

//初始化 事件绑定
function initPageBind() {

    //初始化 年、月 日期选择器：$(".year-day-picker")
    GLOBAL.DATETIMEPICKER.initYearDayPicker();

    //初始化 select2 下拉选择： $(".select2")
    GLOBAL.SELECT2.initSelect2();

    //初始化 模板引擎：$("[data-temple]")被点击时
    //                将 $($(this).attr("data-temple")) 添加至 $($(this).attr("data-templeTo"))
    //                参数 为 $(this).attr("data-temple-param"))
    //                $("[data-temple-delete]")被点击时
    //                删除 他的 父级 $("[data-temple-delete]") 元素
    GLOBAL.TEMPLATE.initTemplate();

    //初始化 Validate验证
    GLOBAL.VALIDATE.initValidate();
}