<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
		<ul class="page-sidebar-menu  page-header-fixed hidden-sm hidden-xs" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200"
			style="padding-top: 20px">
			<li class="sidebar-toggler-wrapper hide">
				<div class="sidebar-toggler">
					<span></span>
				</div>
			</li>
			<c:forEach items="${fns:getCurrentPermissionList()}" var="level1" varStatus="i">
				<c:if test="${level1.parentId eq '1'}">
					<c:forEach items="${fns:getCurrentPermissionList()}" var="level2" varStatus="i">
						<c:if test="${level1.id eq level2.parentId}">
							<li class="nav-item">
								<a href="javascript:;" class="nav-link nav-toggle"> <i class="icon-home"></i> <span class="title">${level2.name}</span> <span class="arrow"></span>
								</a>
								<ul class="sub-menu">
									<li class="nav-item start ">
										<a href="index.html" class="nav-link "> <i class="icon-bar-chart"></i> <span class="title">Dashboard 1</span>
										</a>
									</li>
									<li class="nav-item start ">
										<a href="dashboard_2.html" class="nav-link "> <i class="icon-bulb"></i> <span class="title">Dashboard 2</span> <span class="badge badge-success">1</span>
										</a>
									</li>
								</ul>
							</li>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</ul>
		<!-- END SIDEBAR MENU -->
		<div class="page-sidebar-wrapper">
			<ul class="page-sidebar-menu  page-header-fixed visible-sm visible-xs" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200"
				style="padding-top: 20px">
				<li class="sidebar-toggler-wrapper hide">
					<div class="sidebar-toggler">
						<span></span>
					</div>
				</li>
				<li class="nav-item start ">
					<a href="javascript:;" class="nav-link nav-toggle"> <i class="icon-home"></i> <span class="title">Dashboard</span> <span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li class="nav-item start ">
							<a href="index.html" class="nav-link "> <i class="icon-bar-chart"></i> <span class="title">Dashboard 1</span>
							</a>
						</li>
						<li class="nav-item start ">
							<a href="dashboard_2.html" class="nav-link "> <i class="icon-bulb"></i> <span class="title">Dashboard 2</span> <span class="badge badge-success">1</span>
							</a>
						</li>
					</ul>
				</li>
				<li class="nav-item  ">
					<a href="javascript:;" class="nav-link nav-toggle"> <i class="icon-diamond"></i> <span class="title">UI Features</span> <span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li class="nav-item  ">
							<a href="ui_colors.html" class="nav-link "> <span class="title">Color Library</span>
							</a>
						</li>
						<li class="nav-item  ">
							<a href="ui_general.html" class="nav-link "> <span class="title">General Components</span>
							</a>
						</li>
					</ul>
				</li>
				<li class="nav-item  ">
					<a href="javascript:;" class="nav-link nav-toggle"> <i class="icon-settings"></i> <span class="title">Form Stuff</span> <span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li class="nav-item  ">
							<a href="form_controls.html" class="nav-link "> <span class="title">Bootstrap Form <br>Controls
							</span>
							</a>
						</li>
						<li class="nav-item  ">
							<a href="form_controls_md.html" class="nav-link "> <span class="title">Material Design <br>Form Controls
							</span>
							</a>
						</li>
					</ul>
				</li>
				<li class="nav-item  ">
					<a href="?p=" class="nav-link nav-toggle"> <i class="icon-wallet"></i> <span class="title">Portlets</span> <span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li class="nav-item  ">
							<a href="portlet_boxed.html" class="nav-link "> <span class="title">Boxed Portlets</span>
							</a>
						</li>
						<li class="nav-item  ">
							<a href="portlet_light.html" class="nav-link "> <span class="title">Light Portlets</span>
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>