var Login = function() {

	var handleLogin = function() {

		// 登录验证
		$('.login-form').validate({
			errorElement : 'span', // default input error message container
			errorClass : 'help-block', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			rules : {
				username : {
					required : true,
					rangelength : [ 3, 50 ]
				},
				password : {
					required : true,
					rangelength : [ 5, 50 ]
				}
			},

			messages : {
				username : {
					required : "请输入用户名。",
					rangelength : "用户名长度应在3-50之间"
				},
				password : {
					required : "请输入密码。",
					rangelength : "密码长度应在5-50之间"
				}
			},

			invalidHandler : function(event, validator) { // display error
				// alert on form
				// submit
				// $('.alert-danger', $('.login-form')).show();
			},

			highlight : function(element) { // hightlight error inputs
				$(element).closest('.form-group').addClass('has-error'); // set
				// error
				// class
				// to
				// the
				// control
				// group
			},

			success : function(label) {
				label.closest('.form-group').removeClass('has-error');
				label.remove();
			},

			errorPlacement : function(error, element) {
				error.insertAfter(element.closest('.input-icon'));
			},

			submitHandler : function(form) {
				form.submit();
			}
		});

		$('.login-form input').keypress(function(e) {
			if (e.which == 13) {
				if ($('.login-form').validate().form()) {
					enterLogin();
				}
				return false;
			}
		});

		$("#loginBtn").click(function() {
			if ($('.login-form').validate().form()) {
				enterLogin();
			}
		});

		var enterLogin = function() {
			$.ajax({
				type : 'POST',
				url : ctx + "/login",
				data : $(".login-form").serialize(),
				success : function(res) {
					if (res.type == "success") {
						window.location.href = ctx + "/"
					} else {
						$(".alert-danger span").text(res.message);
						$(".alert-danger").show();
					}
				}
			});
		}
	}

	return {
		// main function to initiate the module
		init : function() {

			handleLogin();

			// init background slide images
			$.backstretch([ ctxStatic + "/metronic/pages/media/bg/1.jpg", ctxStatic + "/metronic/pages/media/bg/2.jpg", ctxStatic + "/metronic/pages/media/bg/3.jpg", ctxStatic + "/metronic/pages/media/bg/4.jpg" ], {
				fade : 1000,
				duration : 8000
			});
		}
	};

}();

jQuery(document).ready(function() {
	Login.init();
});