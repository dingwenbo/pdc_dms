<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="${ctx}/static/jqueryui/css/jquery-ui.min.css"/>
<link rel="stylesheet" href="${ctx}/static/fullcalendar/css/fullcalendar.css"/>
<link rel="stylesheet" href="${ctx}/static/fullcalendar/css/fullcalendar.print.css" media="print"/>
<script src="${ctx}/static/jquery/moment.min.js"></script>
<script src="${ctx}/static/jqueryui/js/jquery-ui.js"></script>
<script src="${ctx}/static/fullcalendar/js/fullcalendar.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		$("#calendar").fullCalendar({
			theme: true,
			contentHeight: 500,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: ''
			},
			editable: true,
			eventLimit: true,
			weekNumbers: true,
			
			dayClick: function(date, jsEvent, view){
				$("#main").load('${ctx}' + "/log/timesheet");
			}
		});
		
	});
</script>
<style>

	body {
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		width: 900px;
		margin: 10px 5px 30px 40px;
	}

</style>
</head>
<body>
	<div id="calendar">
	</div>
</body>
</html>