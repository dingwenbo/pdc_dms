<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>

<link rel="stylesheet" href="${ctx}/static/jqueryui/css/jquery-ui.min.css"/>
<link rel="stylesheet" href="${ctx}/static/jqgrid/css/ui.jqgrid.css"/>
<script src="${ctx}/static/jqueryui/js/jquery-ui.custom.min.js"></script>
<script src="${ctx}/static/jqgrid/js/grid.locale-cn.js"></script>
<script src="${ctx}/static/jqgrid/js/jquery.jqGrid.js"></script>

<script>
	$(function(){
		pageInit();
	});
	function pageInit(){
		$("#timesheet").jqGrid({
			width : 900,
			height : 250,
			datatype : "json",
			colNames : getColNames(),
			colModel : [ 
						{name : 'id',index : 'id',width : 75}, 
						{name : 'task', width : 350,align : "left",editable : true}, 
						{name : 'sun',width : 150,align : "center",formatter:'number',editable : true,editrules:{required:true,custom:true,custom_func:formatData}},
						{name : 'mon',width : 150,align : "center",editable : true},
						{name : 'tue',width : 150,align : "center",editable : true},
						{name : 'wed',width : 150,align : "center",editable : true},
						{name : 'thu',width : 150,align : "center",editable : true},
						{name : 'fri',width : 150,align : "center",editable : true}, 
						{name : 'sat',width : 150,align : "center",editable : true},
						{name : 'total',width : 150,align : "center"}
			],
			rowNum : 10,
			pager : '#ptimesheet',
			viewrecords : true,
			caption : "Timesheet",
			footerrow : true,
			gridComplete : function() {
				var sumSun = $(this).getCol('sun', false, 'sum');
				var sumMon = $(this).getCol('mon', false, 'sum');
				var sumTue = $(this).getCol('tue', false, 'sum');
				var sumWed = $(this).getCol('wed', false, 'sum');
				var sumThu = $(this).getCol('thu', false, 'sum');
				var sumFri = $(this).getCol('fri', false, 'sum');
				var sumSat = $(this).getCol('sat', false, 'sum');
				var sumTotal = sumSun + sumMon + sumTue+sumWed+sumThu+sumFri+sumSat;
				$(this).footerData("set",{"sun":sumSun,"mon":sumMon,"tue":sumTue,"wed":sumWed,"thu":sumThu,"fri":sumFri,"sat":sumSat,"total":sumTotal+'d'}); 
			}
		});
  
		$("#timesheet").jqGrid('setGroupHeaders', {
			useColSpanStyle: false, 
			groupHeaders:[
						{startColumnName: 'id', numberOfColumns: 2, titleText: 'Operational Activity'},
						{startColumnName: 'sun', numberOfColumns: 1, titleText: 'Sun'},
						{startColumnName: 'mon', numberOfColumns: 1, titleText: 'Mon'},
						{startColumnName: 'tue', numberOfColumns: 1, titleText: 'Tue'},
						{startColumnName: 'wed', numberOfColumns: 1, titleText: 'Wed'},
						{startColumnName: 'thu', numberOfColumns: 1, titleText: 'Thu'},
						{startColumnName: 'fri', numberOfColumns: 1, titleText: 'Fri'},
						{startColumnName: 'sat', numberOfColumns: 1, titleText: 'Sat'}
			]  
		});
		
		var mydata = [ 
					{id : "1",task : "Test 01", sun : "", mon : "",tue : "1",wed : "0.5",thu : "1",fri : "",sat : ""}, 
					{id : "2",task : "Test 02", sun : "", mon : "1",tue : "",wed : "0.5",thu : "",fri : "0.5",sat : ""}, 
					{id : "3",task : "Test 03", sun : "", mon : "",tue : "",wed : "",thu : "",fri : "",sat : ""}, 
		];
		for ( var i = 0; i <= mydata.length; i++){
			$("#timesheet").jqGrid('addRowData', i + 1, mydata[i]);
		}
		
		$("#add").click(function(){
			$("#timesheet").jqGrid('addRow');
			this.disabled = 'true';
			$("#save,#cancel").attr("disabled",false);
			$("#edit,#delete").attr("disabled",true);
		});
		$("#edit").click(function(){
			var id=$('#timesheet').jqGrid('getGridParam', 'selrow');
			if (id != null){
				$("#timesheet").jqGrid('editRow',id);
				this.disabled = 'true';
				$("#save,#cancel").attr("disabled",false);
				$("#add,#delete").attr("disabled",true);
			} else {
				alert('Select record');
			}
		});
		$("#delete").click(function(){
			var id=$('#timesheet').jqGrid('getGridParam', 'selrow');
			if (id != null){
				$("#timesheet").jqGrid('delGridRow', id, {
			        reloadAfterSubmit : false
			      });
				this.disabled = 'true';
				$("#save,#cancel").attr("disabled",false);
				$("#add,#edit").attr("disabled",true);
			} else {
				alert('Select record');
			}
		});
		jQuery("#save").click(function() {
			var id=$('#timesheet').jqGrid('getGridParam', 'selrow');
		    var status = jQuery("#timesheet").jqGrid('saveRow', id);
		    if(status) {
			    jQuery("#save,#cancel").attr("disabled", true);
			    jQuery("#add,#edit,#delete").attr("disabled", false);
		    }
		  });
		jQuery("#cancel").click(function() {
			var id=$('#timesheet').jqGrid('getGridParam', 'selrow');
		    jQuery("#timesheet").jqGrid('restoreRow', id);
		    jQuery("#save,#cancel").attr("disabled", true);
		    jQuery("#add,#edit,#delete").attr("disabled", false);
		  });
		
	}
	
	function formatData(value, colname){
		if (value < 0 || value > 1) {
			return [false, "Please enter value between 0 to 1"];
		} else {
			return [true, ""];
		}
	}

	function getCurrentWeekDate(){
		var currentWeekDateTemp = new Array();
		var currentWeekDate = new Array();
		var currentDate = new Date();
		var currentWeekDay = currentDate.getDay();
		for (var i=0;i<=6;i++) {
			if (i != currentWeekDay && i < currentWeekDay) {
				currentWeekDateTemp[i] = currentDate.getDate() - (currentWeekDay - i);
			} else if(i != currentWeekDay && i > currentWeekDay) {
				currentWeekDateTemp[i] = currentDate.getDate() + (i - currentWeekDay);
			} else if(i == currentWeekDay) {
				currentWeekDateTemp[i] = currentDate.getDate();
			}
			currentWeekDate[i] = currentDate.getFullYear() +"/" + currentDate.getMonth() + "/" + currentWeekDateTemp[i];
		}
		currentWeekDate.push("Total");
		return currentWeekDate;
	}

	function getColNames() {
		var columns = ['No', 'Task'];
		return columns.concat(getCurrentWeekDate());
	}
</script>
<style type="text/css">
	html, body {  
		margin: 0;
		padding: 0;
		font-size: 20px;
	}

	.lstTimesheet{
		padding : 20px 5px 30px 50px;
	}
	
	.btn{
		border: 1px solid #aed0ea;
		background-color : #deedf7;
	}
	
</style>
</head>
<body>
	填写timesheet页面
	<div class="lstTimesheet">
		<table id="timesheet"></table> 
	    <div id="ptimesheet"></div>
	    <br>
	    <button class="btn" id="add">Add</button>
	    <button class="btn" id="edit">Edit</button>
	    <button class="btn" id="delete">Delete</button>
	    <button class="btn" id="save" disabled>Save</button>
	    <button class="btn" id="cancel" disabled>Cancel</button>
	</div>
</body>
</html>