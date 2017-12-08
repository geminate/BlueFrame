<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
		<ul class="page-sidebar-menu page-header-fixed" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
			<li class="sidebar-toggler-wrapper hide">
				<div class="sidebar-toggler">
					<span></span>
				</div>
			</li>
			<c:set var="i1" value="0"></c:set>
			<c:forEach items="${fns:getCurrentPermissionList()}" var="level1">
				<c:if test="${(level1.parentId eq '1') and (level1.type eq 0)}">
					<li class="nav-item ${(i1 eq 0)?'start':''}">
						<a data-flag="${level1.permissionStr}" href="<c:if test="${empty level1.href}">javascript:;</c:if><c:if test="${not empty level1.href}">${ctx}${level1.href}</c:if>"
							class="nav-link ${(empty level1.href)?'nav-toggle':''}"> <i class="icon-home"></i> <span class="title">${level1.name}</span> <span class="selected"></span>
							<c:if test="${empty level1.href}">
								<span class="arrow"></span>
							</c:if>
						</a>
						<c:if test="${empty level1.href}">
							<ul class="sub-menu">
								<c:forEach items="${fns:getCurrentPermissionList()}" var="level2">
									<c:if test="${(level1.id eq level2.parentId) and (level1.type eq 0)}">
										<li class="nav-item">
											<a data-flag="${level1.permissionStr}" href="<c:if test="${empty level2.href}">javascript:;</c:if><c:if test="${not empty level2.href}">${ctx}${level2.href}</c:if>"
												class="nav-link ${(empty level2.href)?'nav-toggle':''}"> <i class="icon-settings"></i> <span class="title">${level2.name}</span> <c:if
													test="${empty level2.href}">
													<span class="arrow"></span>
												</c:if>
											</a>
											<c:if test="${empty level2.href}">
												<ul class="sub-menu">
													<c:forEach items="${fns:getCurrentPermissionList()}" var="level3" varStatus="i">
														<c:if test="${(level2.id eq level3.parentId) and (level1.type eq 0)}">
															<li class="nav-item">
																<a data-flag="${level1.permissionStr}" href="${ctx}${level3.href}" class="nav-link"> <i class="icon-settings"></i> ${level3.name}
																</a>
															</li>
														</c:if>
													</c:forEach>
												</ul>
											</c:if>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</c:if>
					</li>
					<c:set var="i1" value="${i1+1}"></c:set>
				</c:if>
			</c:forEach>
		</ul>
		<!-- END SIDEBAR MENU -->
	</div>
</div>