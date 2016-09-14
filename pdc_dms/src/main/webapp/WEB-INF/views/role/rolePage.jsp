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
		  jQuery("#role1").jqGrid({
		      datatype: "local",
		      height: 100,
		      colNames: ['id1', 'Name1', 'Values1'],
		      colModel: [
		                 {name: 'id1',index: 'id',width: 100}, 
		                 {name: 'name1',index: 'name',width: 100}, 
		                 {name: 'values1',index: 'values',width: 200}
		                 ],
		      caption: 'Role 1',
		      pager: '#prole1'
		  });
		  jQuery("#role2").jqGrid({
		      datatype: "local",
		      height: 100,
		      colNames: ['Id2', 'Name2', 'Values2'],
		      colModel: [
		                 {name: 'id2',index: 'id',width: 100}, 
		                 {name: 'name2',index: 'name',width: 100},
		                 {name: 'values2',index: 'values',width: 200}
		                 ],
		      caption: 'Grid 2',
		      pager: '#pgrid2'
		  });
		  var mydata1 = [
		      {id1:"1",name1:"test1",values1:'One'},
		      {id1:"2",name1:"test2",values1:'Two'},
		      {id1:"3",name1:"test3",values1:'Three'}
		  ];
		  var mydata2 = [
		      {id2:"11",name2:"test11",values2:'One1'},
		      {id2:"21",name2:"test21",values2:'Two1'},
		      {id2:"31",name2:"test31",values2:'Three1'}
		  ];
		  for (var i = 0; i <= mydata1.length; i++) {
		      jQuery("#role1").jqGrid('addRowData',i + 1, mydata1[i]);
		      jQuery("#role2").jqGrid('addRowData',i + 1, mydata2[i]);
		  }
		  
		  jQuery("#role1").jqGrid('gridDnD',{connectWith:'#role2'});
		  jQuery("#role2").jqGrid('gridDnD',{connectWith:'#role1'});

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
	角色页面
	<table>
      <tbody>
          <tr>
              <td><table id="role1"></table><div id="prole1"></div></td>
              <td align="center"> &lt;===&gt;</td>
              <td><table id="role2"></table><div id="prole2"></div></td>
          </tr>
      </tbody>
    </table>

</body>
</html>