<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		pageInit();
	});
	
	function pageInit(){
// 		var lastsel;
// 		$('#tableProject').jqGrid({
// 			url : "${ctx}/projectManagement/getProjectData",
// 			width : 900,
// 			height : 250,
// 			dataType : "json",
// 			colNames : getColNames(),
// 		});
	}
</script>

</head>
<body>
	项目管理页面
	<div class="divProject">
		<table id="tableProject"></table> 
	    <div id="pagerProject"></div>
	    <br>
	    <button class="btn" id="add">Add</button>
	    <button class="btn" id="edit">Edit</button>
	    <button class="btn" id="delete">Delete</button>
	    <button class="btn" id="save" disabled>Save</button>
	    <button class="btn" id="cancel" disabled>Cancel</button>
	</div>
</body>
</html>