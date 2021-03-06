<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	//动态生成标签
	function myelem (value, options) {
	  var span = document.createElement("span");
	  span.innerHTML = value;
	  return span;
	}

	function myvalue(elem, operation, value) {
	    if(operation === 'get') {
	       return $(elem).html();
	    } else if(operation === 'set') {
	       $('span',elem).innerHTML = value;
	    }
	}

    function updateJqGrid(jqGrid) {
        var colModel = jqGrid.colModel;
//         var obj = {editrules:{required:true},editoptions:{size:20},formoptions:{elmprefix:'<span style=\'color:red\'>*&nbsp;&nbsp;</span>'},searchoptions:{sopt:['cn']}};

        $.extend(true, colModel[1], {editrules:{required:true},editoptions:{size:20},formoptions:{elmprefix:'<span style=\'color:red\'>*&nbsp;&nbsp;</span>'},searchoptions:{sopt:['cn']}});
        $.extend(true, colModel[2], {editrules:{required:true},editoptions:{size:30},formoptions:{elmprefix:'<span style=\'color:red\'>*&nbsp;&nbsp;</span>'},searchoptions:{sopt:['cn']}});
        $.extend(true, colModel[3], {editrules:{required:true},editoptions:{size:40},formoptions:{elmprefix:'<span style=\'color:red\'>*&nbsp;&nbsp;</span>'},searchoptions:{sopt:['cn']}});
        $.extend(true, colModel[4], {search:true,formoptions:{elmprefix:'<span>&nbsp;&nbsp;&nbsp;</span>'},searchoptions:{sopt:['cn']}});
        $.extend(true, colModel[5], {search:true,formoptions:{elmprefix:'<span>&nbsp;&nbsp;&nbsp;</span>'},searchoptions:{sopt:['cn']}});
        return jqGrid;
    }

	function pageInit(){
        //TODO
        var id = "tableProject";
//         var url = "${ctx}/projectManagement/jqGrid.action";
//         initJqGrid(url, id, updateJqGrid);
        var jqGridTable = new JqGrid_Table(id);

        $.extend(true, jqGridTable.jqGridModel, {url : "${ctx}/projectManagement/getProjectData.action", width : 900, height : 250, caption : "项目管理", pager : "pagerProject"});
        $.extend(true, jqGridTable.newColModel(), {name : "id", index : "id", hidden : true});
        $.extend(true, jqGridTable.newColModel(), {name : "code", index : "code"});
        $.extend(true, jqGridTable.newColModel(), {name : "fullName"});
        $.extend(true, jqGridTable.newColModel(), {name : "label", width : 400});
        $.extend(true, jqGridTable.newColModel(), {name : "parentCode", edittype : "select"});
        $.extend(true, jqGridTable.newColModel(), {name : "managerName", align : "center", edittype : "select"});

        jqGridTable.handleJqGridTable(updateJqGrid);
        jqGridTable.updateColNames(["No", "Code", "Full_Name", "Label", "父项目Code", "PM"]);
        jqGridTable.jqGrid();

        $('#tableProject').jqGrid('filterToolbar',{
			searchOperators : true
		});

		$('#add').click(function() {
		    $("#tableProject").jqGrid('editGridRow', 'new', {
		    	addCaption: '添加一个新的项目',
		    	top : 250,
		    	left : 700,
		    	width : 500,
		      	dataheight : 180,
		      	addedrow : 'last',
		      	closeAfterAdd : true,
		      	closeOnEscape : true,
		      	url : '${ctx}/projectManagement/addProjectData.action',
		      	beforeInitData : function() {
		      		$('#tableProject').jqGrid('setColProp', 'code', {edittype:"text", formoptions:{elmprefix:'<span style=\'color:red\'>*&nbsp;&nbsp;</span>'}});
		      		getParentProject(null);
		      		getMemberCode();
		      	},
		      	afterComplete : function(data){
		      		var messageInfo = eval("("+data.responseText+")");
		      		if (messageInfo.code == 'error') {
		      			dmsAlert(messageInfo.messageInfo);
		      		}
		      	},
		      	afterSubmit:function() {
		      	 	$("#tableProject").jqGrid('setGridParam',{datatype:'json',page:1}).trigger('reloadGrid');
		      	 	return [true,"",""];
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
			    	width : 500,
			      	dataheight : 180,
			      	viewPagerButtons : false,
					closeAfterEdit : true,
					closeOnEscape : true,
					url : '${ctx}/projectManagement/editProjectData.action',
					beforeInitData : function() {
						$('#tableProject').jqGrid('setColProp', 'code', {editrules:{required:false},edittype:"custom", editoptions:{custom_element:myelem,custom_value:myvalue}, formoptions:{elmprefix:'<span></span>'}});
						var id=$('#tableProject').jqGrid('getGridParam', 'selrow');
						getParentProject(id);
						getMemberCode();
			      	},
			      	afterSubmit:function() {
			      	 	$("#tableProject").jqGrid('setGridParam',{datatype:'json',page:1}).trigger('reloadGrid');
			      	 	return [true,"",""];
			      	}
				});
			} else {
				dmsAlert("请选择需要修改的数据");
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
					url : '${ctx}/projectManagement/deleteProjectData.action',
					afterSubmit:function() {
			      	 	$("#tableProject").jqGrid('setGridParam',{datatype:'json',page:1}).trigger('reloadGrid');
			      	 	return [true,"",""];
			      	}
				});
			} else {
				dmsAlert("请选择需要删除的数据");
			}
		});
		
		$('#filter').click(function(){
			$('#tableProject')[0].triggerToolbar(); 
		});
	}

	function getParentProject(id) {
		var str = "";
		$.ajax({
			type:"POST",
			async:false,
			data: $('#tableProject').jqGrid('getRowData', id),
			url: "${ctx}/projectManagement/getParentProject.action",
			success:function(data){ 
				if (data != null && data != "") { 
				  var jsonobj = eval("("+data+")");
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

	function getMemberCode() {
		var str = "";
		$.ajax({
			type: "POST",
			async: false,
			url: "${ctx}/projectManagement/getMemberCode.action",
			success: function(data) {
				if (data != null && data != "") {
					var jsonobj = eval("("+data+")");
					var length = jsonobj.length;
					if (length > 0) {
						str = "0:无;";
						for (var i=0;i<length;i++) {
							if (i != length - 1) {
								str += jsonobj[i].id + ":" + jsonobj[i].name + ";";
							} else {
								str += jsonobj[i].id + ":" + jsonobj[i].name;
							}
						}
					} else {
						  str = "0:无";
					}
				}
			}
		});
		$('#tableProject').jqGrid('setColProp', 'managerName', {editoptions: {value: str}});
	}
</script>
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
}

.divProject {
	padding: 20px 5px 30px 50px;
	font-size: 20px;
}

.btn {
	border: 1px solid #aed0ea;
	background-color: #deedf7;
}
</style>
</head>
<body>
	<div class="divProject">
		<table id="tableProject"></table>
		<div id="pagerProject"></div>
		<br>

		<button class="btn" id="add">Add</button>
		<button class="btn" id="edit">Edit</button>
		<button class="btn" id="delete">Delete</button>
		<button class="btn" id="filter">Filter</button>
	</div>
</body>
</html>