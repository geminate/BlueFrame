<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner ">
		<div class="page-logo">
			<a href=""> <img src="${ctxStatic}/metronic/layouts/layout/img/logo.png" alt="logo" class="logo-default" />
			</a>
			<div class="menu-toggler sidebar-toggler">
				<span></span>
			</div>
		</div>		
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> <span></span>
		</a>
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-user ">
					<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <img alt="" class="img-circle"
							src="${ctxStatic}/metronic/layouts/layout/img/avatar3_small.jpg" /> <span class="username username-hide-on-mobile"> ${fns:getCurrentUser().name}
					</span> <i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li>
							<a href="page_user_profile_1.html"> <i class="icon-user"></i> 个人信息
							</a>
						</li>
						<li>
							<a href="page_user_profile_1.html"> <i class="icon-key"></i> 修改密码
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="${ctx}/logout"> <i class="icon-key"></i> 退出登录
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>