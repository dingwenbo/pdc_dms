<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({ cache: false });
		pageInit();
	});
	
	function pageInit(){
		var lastsel;
		$('#tableProject').jqGrid({
			url : "${ctx}/projectManagement/getProjectData.action",
			width : 900,
			height : 250,
			mtype : "POST",
			datatype : "json",
			colNames : ['No','Code','Full_Name','Label','父项目Code'],
			colModel : [
			            {name: 'id', index: 'id', width: 75, search: false, hidden:true},
			            {name: 'code',index: 'code',width: 350,align: 'left',editable: true, editrules:{required:true},formoptions:{elmprefix:'<span style=\'color:red\'>*</span>'},searchoptions:{sopt:['cn']}},
			            {name: 'fullName',width: 350,align: 'left',editable: true, editrules:{required:true},formoptions:{elmprefix:'<span style=\'color:red\'>*</span>'},searchoptions:{sopt:['cn']}},
			            {name: 'label',width: 350,align: 'left',editable: true, editrules:{required:true},formoptions:{elmprefix:'<span style=\'color:red\'>*</span>'},searchoptions:{sopt:['cn']}},
			            {name: 'parentCode',width: 350,align: 'left',editable: true, edittype:'select', editoptions:{value: getParentProject()}, searchoptions:{sopt:['cn']}}
			],
			rownumbers : true,
			caption : "项目管理",
			editurl : '${ctx}/projectManagement/editProjectData.action'
		});
		
		$("#tableProject").jqGrid('filterToolbar',{
			searchOperators : true
		});
		
		$("#add").click(function() {
		    $("#tableProject").jqGrid('editGridRow', 'new', {
		    	addCaption: '添加一个新的项目',
		    	top : 250,
		    	left : 700,
		    	width : 400,
		      	dataheight : 180,
		      	reloadAfterSubmit : true,
		      	addedrow : 'last',
		      	closeAfterAdd : true,
		      	beforeInitData : function() {
		      		getParentProject();
		      	},
		      	afterComplete : function(xhr){
		      		if (xhr.responseText == 'error') {
		      			$("#dialog").dialog({
// 		      				width: 300,
// 		      				height: 50,
// 		      				resizable: false
		      				 bgiframe: true,
		      			    resizable: false,
		      			    height:140,
		      			    modal: true,
		      			    overlay: {
		      			        backgroundColor: '#000',
		      			        opacity: 0.8
		      			    },
		      			});
		      		}
		      	}
		    });
		  });
		
		$('#edit').click(function(){
			var id=$('#tableProject').jqGrid('getGridParam', 'selrow');
			if (id != null) {
				$('#tableProject').jqGrid('editGridRow', id, {
					editCaption: '编辑项目',
					top : 250,
			    	left : 700,
			    	width : 400,
			      	dataheight : 180,
					closeAfterEdit : true,
					closeOnEscape : true
				});
			} else {
				alert('请选择需要修改的数据');
			} 
		});
		
		$('#delete').click(function(){
			var id=$('#tableProject').jqGrid('getGridParam', 'selrow');
			if (id != null) {
				$('#tableProject').jqGrid('delGridRow', id, {
					top : 250,
			    	left : 700,
					caption : '删除项目',
					msg : '确定要删除此项目吗?',
					url : '${ctx}/projectManagement/deleteProjectData.action'
				});
			} else {
				alert('请选择需要删除的数据');
			}
		});
	}
	
	function getParentProject() {
		$.ajax({
			type:"POST",
			async:false, 
			url:"${ctx}/projectManagement/getParentProject.action",
			success:function(data){ 
				str = "";
				if (data != null) { 
				  var jsonobj = eval(data);
				  var length = jsonobj.length;
				  if (length > 0) {
					  str = "0:无;";
					  for (var i=0;i<length;i++) {
						  if(i!=length-1) {
							  str += jsonobj[i].id+":"+jsonobj[i].code+";";
						  } else {
							  str += jsonobj[i].id + ":" + jsonobj[i].code;
						  }
					  }
				  } else {
					  str = "0:无";
				  }
				}
			}
		}); 
		$('#tableProject').jqGrid('setColProp', 'parentCode', { editoptions: { value: str} });
	}
	
	function onClickFilterTable(){
		
	}
</script>
<style type="text/css">
	html, body {  
		margin: 0;
		padding: 0;
		font-size: 20px;
	}

	.divProject{
		padding : 20px 5px 30px 50px;
	}
	
	.btn{
		border: 1px solid #aed0ea;
		background-color : #deedf7;
	}
	
</style>
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
		    <button class="btn" id="filter">Filter</button>
	</div>
	<div id="dialog">
	</div>
</body>
</html>