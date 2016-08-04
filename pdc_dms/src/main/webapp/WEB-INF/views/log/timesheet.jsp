<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	$(function(){
		pageInit();
	});
	function pageInit(){
		var lastsel;
		$("#timesheet").jqGrid({
			url : "${ctx}/log/getTimeSheetData.action",
			width : 900,	//表格宽度
			height : 250,	//表格高度
			mtype: "POST", //提交方式
			datatype : "json",	//服务器端返回的数据类型
			colNames : getColNames(), //表title
			//表数据模型
			colModel : [ 
						{name : 'id',index : 'id', width : 75}, 
						{name : 'task', width : 350, align : "left", editable : true, editrules:{required:true}}, 
						{name : 'sun', width : 150, align : "center", editable: true, editoptions:{dataEvents:[{type:'blur',fn:validateInput}]}, editrules:{number:true,custom:true,custom_func:formatData}},
						{name : 'mon', width : 150, align : "center", editable: true, editoptions:{dataEvents:[{type:'blur',fn:validateInput}]}, editrules:{number:true,custom:true,custom_func:formatData}},
						{name : 'tue', width : 150, align : "center", editable: true, editoptions:{dataEvents:[{type:'blur',fn:validateInput}]}, editrules:{number:true,custom:true,custom_func:formatData}},
						{name : 'wed', width : 150, align : "center", editable: true, editoptions:{dataEvents:[{type:'blur',fn:validateInput}]}, editrules:{number:true,custom:true,custom_func:formatData}},
						{name : 'thu', width : 150, align : "center", editable: true, editoptions:{dataEvents:[{type:'blur',fn:validateInput}]}, editrules:{number:true,custom:true,custom_func:formatData}},
						{name : 'fri', width : 150, align : "center", editable: true, editoptions:{dataEvents:[{type:'blur',fn:validateInput}]}, editrules:{number:true,custom:true,custom_func:formatData}}, 
						{name : 'sat', width : 150, align : "center", editable: true, editoptions:{dataEvents:[{type:'blur',fn:validateInput}]}, editrules:{number:true,custom:true,custom_func:formatData}},
						{name : 'total', width : 150, align : "center"}
			],
			rowNum : 10,
			rowList : [10, 15, 20], //用于改变显示行数的下拉列表框的元素数组。
			pager : 'ptimesheet',
			viewrecords : true,
			caption : "我的Timesheet",
			footerrow : true,	//汇总列
			gridComplete : sumColumn,
			onSelectRow: function(id){
				if(id && id!==lastsel){
					$('#timesheet').restoreRow(lastsel);
					lastsel=id;
					$("#save,#cancel").attr("disabled",true);
					$("#add,#edit,#delete").attr("disabled",false);
				}
			}
		});
		
		//分组表头
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
		
		//添加按钮
		$("#add").click(function(){
			$("#timesheet").jqGrid('addRow', {
				position : 'last'
			});
			this.disabled = 'true';
			$("#save,#cancel").attr("disabled",false);
			$("#edit,#delete").attr("disabled",true);
		});
		//修改按钮
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
		//删除按钮
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
		//保存按钮
		$("#save").click(function() {
			var id=$('#timesheet').jqGrid('getGridParam', 'selrow');
		    var status = $("#timesheet").jqGrid('saveRow', id);
		    if(status) {
		    	sumColumn();
			    $("#save,#cancel").attr("disabled", true);
			    $("#add,#edit,#delete").attr("disabled", false);
		    } else {
			    $("#save,#cancel").attr("disabled", false);
			    $("#add,#edit,#delete").attr("disabled", true);
		    }
		    
		});
		//取消按钮
		$("#cancel").click(function() {
			var id=$('#timesheet').jqGrid('getGridParam', 'selrow');
		    $("#timesheet").jqGrid('restoreRow', id);
		    $("#save,#cancel").attr("disabled", true);
		    $("#add,#edit,#delete").attr("disabled", false);
		  });
		
		//刷新按钮
		$("refresh").click(function() {
			var id = $('#timesheet').jqGrid
		});
	}
	
	function formatData(value, colname){
		if (value < 0 || value > 1) {
			return [false, "Please enter value between 0 to 1"];
		} else {
			return [true, ""];
		}
	}

	function validateInput(e){
		var sumColumn = parseFloat($('#timesheet').getCol($(this).attr('name'), false, 'sum'));
		var cellVal = parseFloat($(this).val());
		var totalDay = sumColumn + cellVal;
		if (totalDay >1 || totalDay < 0) {
			$(this).val('');
			alert('Please confirm your work day');
		}
	}
	
	function sumColumn() {
		var sumSun = $('#timesheet').getCol('sun', false, 'sum');
		var sumMon = $('#timesheet').getCol('mon', false, 'sum');
		var sumTue = $('#timesheet').getCol('tue', false, 'sum');
		var sumWed = $('#timesheet').getCol('wed', false, 'sum');
		var sumThu = $('#timesheet').getCol('thu', false, 'sum');
		var sumFri = $('#timesheet').getCol('fri', false, 'sum');
		var sumSat = $('#timesheet').getCol('sat', false, 'sum');
		var sumTotal = sumSun + sumMon + sumTue+sumWed+sumThu+sumFri+sumSat;
		$('#timesheet').footerData("set",{"sun":sumSun,"mon":sumMon,"tue":sumTue,"wed":sumWed,"thu":sumThu,"fri":sumFri,"sat":sumSat,"total":sumTotal+'d'});
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
	    <button class="btn" id="refresh">Refresh</button>
	    <button class="btn" id="save" disabled>Save</button>
	    <button class="btn" id="cancel" disabled>Cancel</button>
	</div>
</body>
</html>