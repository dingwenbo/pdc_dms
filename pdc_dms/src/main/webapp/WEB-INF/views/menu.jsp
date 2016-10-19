<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${ctx}/static/styles/menu.css" rel="stylesheet">
<title>首页</title>
<script type="text/javascript">
$(function() {
	// 进入首页，加载首页的信息
    gotoUrl(null, '/menu/showHomePage');
});

function gotoUrl(obj, action) {
	$("#main").load('${ctx}' + action, checkSessionTimeout);
    
}
function checkSessionTimeout() {
    if ($(".form-login").size() > 0) {
        window.top.location.href = "${ctx}/login";
    }  
}
</script>
</head>
<body>
    <div class="navbar navbar-duomi navbar-static-top" role="navigation" style="z-index : 1;">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" id="logo">
                </a>
            </div>
        </div>
    </div>

    <div class="container-fluid">
            <div class=""  style="width:10%;float:left; height:100%;">
                <ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
                    <li>
                        <a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/menu/showHomePage');">
                            <i class="glyphicon glyphicon-th-large"></i>
                                                       首页 		
                        </a>
                    </li>
                    <li>
              			<a href="#logManagement" class="nav-header collapsed" data-toggle="collapse">
              				<i class="glyphicon glyphicon-tags"></i>
							日志管理
							<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
              			</a>
              			<ul id="logManagement" class="nav nav-list secondmenu collapse" style="height: 0px;">
              				<li>
              					<a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/log/timesheet');">
              						<i class="glyphicon glyphicon-pencil"></i>&nbsp;Timesheet填写
              					</a>
              				</li>
              				<!-- TL级别以上并且拥有特定的权限 -->
              				<li>
              					<a href="#">
              						<i class="glyphicon glyphicon-pencil"></i>&nbsp;项目看板
              					</a>
              				</li>
              				<!-- TL级别以上并且拥有特定的权限 -->
              				<li>
              					<a href="#">
              						<i class="glyphicon glyphicon-pencil"></i>&nbsp;工时详细
              					</a>
              				</li>
              			</ul>
                    </li>
                    <li>
              			<a href="#roleManagement" class="nav-header collapsed" data-toggle="collapse">
              				<i class="glyphicon glyphicon-user"></i>
							角色管理
							<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
              			</a>
              			<ul id="roleManagement" class="nav nav-list secondmenu collapse" style="height: 0px;">
              				<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;我的下级</a></li>
              			</ul>
                    </li>
                    <li>
              			<a href="#projectManagement" class="nav-header collapsed" data-toggle="collapse">
              				<i class="glyphicon glyphicon-align-justify"></i>
							项目管理
							<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
              			</a>
              			<ul id="projectManagement" class="nav nav-list secondmenu collapse" style="height: 0px;">
              				<li>
              					<a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/projectManagement/project');">
              						<i class="glyphicon glyphicon-cog"></i>&nbsp;
              						项目管理
              					</a>
              				</li>
              				<li>
              					<a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/projectManagement/task');">
              						<i class="glyphicon glyphicon-cog"></i>&nbsp;
              						任务管理
              					</a>
              				</li>
              			</ul>
                    </li>
                    <li>
              			<a href="#myProfile" class="nav-header collapsed" data-toggle="collapse">
              				<i class="glyphicon glyphicon-align-justify"></i>
							我的档案
							<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
              			</a>
              			<ul id="myProfile" class="nav nav-list secondmenu collapse" style="height: 0px;">
              				<li><a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/member/memberInfo');"><i class="glyphicon glyphicon-cog"></i>&nbsp;我的档案</a></li>
              				<li><a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/member/modifyPassword');"><i class="glyphicon glyphicon-cog"></i>&nbsp;修改密码</a></li>
              				<li><a href="javascript:void(0);" onclick="javascript:gotoUrl(this, '/logout');"><i class="glyphicon glyphicon-log-out"></i>&nbsp;安全退出</a></li>
              			</ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/menu/showAbout');">
                            <i class="glyphicon glyphicon-fire"></i>
                            关于系统
                            <span class="badge pull-right"></span>
                        </a>
                    </li>

                </ul>
            </div>
            <div id="main" class="" style="width:90%; float:left;">
            </div>
    </div>
	<div class="navbar navbar-duomi navbar-static-top" role="navigation" style="z-index : 1;">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" id="logo">
                </a>
            </div>
        </div>
    </div>
</body>
</html>