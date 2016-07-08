<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${ctx}/static/styles/login/login.css" rel="stylesheet">

<!-- Page Title -->
<title>欢迎登录PDC日常管理系统</title>
<script type="text/javascript">

</script>
</head>
<body>
	<div class="container">
		<form class="form-login" action="${ctx}/login" method="post">
			<h2 class="form-login-heading">请登录系统</h2>
			<label for="username" class="sr-only">你的PDC ID：</label>
			<input type="text" id="username" name="username" class="form-control" value="${username}" placeholder="你的PDC ID" required autofocus /> 
			<label for="password" class="sr-only">密码：</label>
			<input type="password" id="password" name="password" class="form-control" placeholder="密码" required />
			<div class="checkbox">
				<label><input type="checkbox" value="remember-me">记住我</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="">登录</button>
		</form>
	</div>
</body>
</html>