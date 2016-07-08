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
	$("#main").load('${ctx}' + '/main/showHomePage');
});

function gotoUrl(obj, action) {
	$("#main").load('${ctx}' + action);
}
</script>
</head>
<body>
    <div class="navbar navbar-duomi navbar-static-top" role="navigation">
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
                        <a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/main/showHomePage');">
                            <i class="glyphicon glyphicon-th-large"></i>
                                                       首页 		
                        </a>
                    </li>
                    <li>
              			<a href="" class="nav-header collapsed" data-toggle="collapse">
              				<i class="glyphicon glyphicon-tags"></i>
							日志填写
							<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
              			</a>
              			<ul id="" class="nav nav-list secondmenu collapse" style="height: 0px;">
              				<li><a href="#"><i class="glyphicon glyphicon-pencil"></i>&nbsp;Timesheet填写</a></li>
              				
              				<!-- SE级别以上 -->
              				<li><a href="#"><i class="glyphicon glyphicon-pencil"></i>&nbsp;任务状态</a></li>
              				
              				<!-- TL级别以上并且拥有特定的权限 -->
              				<li><a href="#"><i class="glyphicon glyphicon-pencil"></i>&nbsp;项目看板</a></li>
              				<!-- TL级别以上并且拥有特定的权限 -->
              				<li><a href="#"><i class="glyphicon glyphicon-pencil"></i>&nbsp;工时详细</a></li>
              			</ul>
                    </li>
                    <li>
              			<a href="" class="nav-header collapsed" data-toggle="collapse">
              				<i class="glyphicon glyphicon-user"></i>
							角色管理
							<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
              			</a>
              			<ul id="" class="nav nav-list secondmenu collapse" style="height: 0px;">
              				<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;我的下级</a></li>
              			</ul>
                    </li>
                    <li>
              			<a href="" class="nav-header collapsed" data-toggle="collapse">
              				<i class="glyphicon glyphicon-align-justify"></i>
							我的档案
							<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
              			</a>
              			<ul id="" class="nav nav-list secondmenu collapse" style="height: 0px;">
              				<li><a href="#"><i class="glyphicon glyphicon-cog"></i>&nbsp;我的档案</a></li>
              				<li><a href="#"><i class="glyphicon glyphicon-cog"></i>&nbsp;我的项目</a></li>
              				<li><a href="#"><i class="glyphicon glyphicon-cog"></i>&nbsp;我的任务</a></li>
              				<li><a href="#"><i class="glyphicon glyphicon-cog"></i>&nbsp;修改密码</a></li>
              				<li><a href="#"><i class="glyphicon glyphicon-log-out"></i>&nbsp;退出登陆</a></li>
              			</ul>
                    </li>
                    
<!--                     <li> -->
<!--                         <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse"> -->
<!--                             <i class="glyphicon glyphicon-cog"></i> -->
<!--                             系统管理 -->
                            
<!--                             <span class="pull-right glyphicon glyphicon-chevron-toggle"></span> -->
<!--                         </a> -->
<!--                         <ul id="systemSetting" class="nav nav-list secondmenu collapse" style="height: 0px;"> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;菜单管理</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="#configSetting" class="nav-header collapsed" data-toggle="collapse"> -->
<!--                             <i class="glyphicon glyphicon-credit-card"></i> -->
<!--                             配置管理	 -->
<!--                                    <span class="pull-right glyphicon  glyphicon-chevron-toggle"></span> -->
<!--                         </a> -->
<!--                         <ul id="configSetting" class="nav nav-list secondmenu collapse"> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-globe"></i>&nbsp;全局缺省配置</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-star-empty"></i>&nbsp;未开通用户配置</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-star"></i>&nbsp;退订用户配置</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-text-width"></i>&nbsp;试用用户配置</a></li> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-ok-circle"></i>&nbsp;开通用户配置</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<!--                         <a href="#disSetting" class="nav-header collapsed" data-toggle="collapse"> -->
<!--                             <i class="glyphicon glyphicon-globe"></i> -->
<!--                             分发配置 -->
<!-- 							 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span> -->
<!--                         </a> -->
<!--                         <ul id="disSetting" class="nav nav-list secondmenu collapse"> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;分发包配置</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<!--                         <a href="#dicSetting" class="nav-header collapsed" data-toggle="collapse"> -->
<!--                             <i class="glyphicon glyphicon-bold"></i> -->
<!--                             字典配置 -->
<!--                             <span class="pull-right glyphicon glyphicon-chevron-toggle"></span> -->
<!--                         </a> -->
<!--                         <ul id="dicSetting" class="nav nav-list secondmenu collapse"> -->
<!--                             <li><a href="#"><i class="glyphicon glyphicon-text-width"></i>&nbsp;关键字配置</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->
                    <li>
                        <a href="javascript:void(0);" onclick="javascript:gotoUrl(this,'/main/showAbout');">
                            <i class="glyphicon glyphicon-fire"></i>
                            关于系统
                            <span class="badge pull-right">1</span>
                        </a>
                    </li>

                </ul>
            </div>
            <div id="main" class="" style="width:90%; float:left;">
            </div>
    </div>
	<div class="navbar navbar-duomi navbar-static-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" id="logo">
                </a>
            </div>
        </div>
    </div>
</body>
</html>