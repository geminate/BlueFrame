//DATATABLE 命名空间
(function () {
    GLOBAL.namespace("DATATABLE");

    /**
     * 初始化 Datatable
     * @param table table的Dom选择器字符串         (必须)
     * @param url   数据请求地址                   (必须)
     * @param form  查询Form的Dom选择器字符串       (可为 null)
     * @param columns 列数组                       (必须)
     * @param freshBtn 查询按钮的Dom选择器字符串    (可为 null)
     * @param resetBtn 重置按钮的Dom选择器字符串    (可为 null)
     * @returns {jQuery}
     *
     * @author hhliu
     */
    GLOBAL.DATATABLE.initDatatable = function (table, url, form, columns, freshBtn, resetBtn) {
        var $form;
        if (form == null) {
            var nullForm = document.createElement("form");
            $form = $(nullForm);
        } else {
            $form = $(form);
        }

        var setting = {
            "autoWidth": true,
            "order": [],
            "orderCellsTop": true,
            "searching": false,
            "processing": true,
            "serverSide": true,
            "ajax":
                {
                    "url": url,
                    "type": "POST",
                    "data": function (d) {
                        return $.extend({}, d, GLOBAL.JQUERY.addSerializeObject($(form)));
                    }
                },
            "columns": columns,
            "language": {
                "processing": "加载中...",
                "lengthMenu": "每页 _MENU_ 条记录",
                "zeroRecords": "没有找到记录",
                "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                "infoEmpty": "无记录",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                "paginate": {
                    "first": "首页",
                    "last": "末页",
                    "next": "下一页",
                    "previous": "上一页"
                },

            }
        };

        var re = $(table).DataTable(setting);

        if (freshBtn != null) {
            $(freshBtn).click(function () {
                re.ajax.reload();
            });
        }

        if (resetBtn != null) {
            $(resetBtn).click(function () {
                $(form)[0].reset();
                re.ajax.reload();
            });
        }

        return re;
    };

    /**
     * datatable 删除行 按钮
     * @param element 删除按钮Dom字符
     */
    GLOBAL.DATATABLE.deleteRow = function (element) {
        $.confirm({
            title: '确定删除？',
            type: 'orange',
            backgroundDismiss: true,
            content: "",
            buttons: {
                "确定": {
                    btnClass: 'btn-success',
                    action: function () {
                        var url = $(element).attr("data-datatable-url");
                        var table = $($(element).attr("data-datatable-table"));
                        var param = $(element).attr("data-datatable-param");

                        $.post(url, {id: param}, function (re) {
                            if (re != null && re.type != null && re.type != "") {
                                toastr[re.type](re.title, re.message);
                                $(table).DataTable().draw();
                            }
                        });

                    }
                },
                "取消": {btnClass: 'btn-danger'}
            }
        });
    };
})();
