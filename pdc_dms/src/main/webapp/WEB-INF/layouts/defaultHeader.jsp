<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="header">
	<div id="title">
	    <h1><a href="${ctx}">PDC日常管理系统</a><small></small>
	    <shiro:user>
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i> <shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
			
				<ul class="dropdown-menu" style="z-index:1001;">
					<shiro:hasRole name="Admin">
						<li><a href="${ctx}/admin/member">Admin Members</a></li>
						<li class="divider"></li>
					</shiro:hasRole>
                    <li><a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/member/memberInfo');">我的档案</a></li>
					<li><a href="${ctx}/profile">Edit Profile</a></li>
					<li><a href="${ctx}/logout">Logout</a></li>
				</ul>
			</div>
		</shiro:user>
		</h1>
	</div>
</div>