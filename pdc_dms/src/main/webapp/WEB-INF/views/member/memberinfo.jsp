<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的档案</title>
<link href="${ctx}/static/styles/menu.css" rel="stylesheet">
<link href="${ctx}/static/styles/dms.css" rel="stylesheet">

<script type="text/javascript">
    function updateMember() {
        if (validateMemberForm()) {
            $("#memberForm").submit();
        }
    }

    function validateMemberForm() {
        var flag = true;
        var checkNum = /^-?\d+$/;
        var phoneTrim = /\s+/g;
        var phoneReg = /^1[3|4|5|7|8]\d{9}$/;
        var supervisorId = $("#supervisorId").val();
        var phone = $("#phone").val().replace(phoneTrim, '');

        /* validate supervisorId */
        if (null != supervisorId && "" != supervisorId) {
            if (!checkNum.test(supervisorId) || supervisorId<-32768 || supervisorId>32767) {
                flag = false;
                alert("supervisorId 不是整数或超出范围！");
            }
        }

        /* validate phone */
        if (null != phone && "" != phone) {
            if (!phoneReg.test(phone)) {
                flag = false;
                alert("电话号码输入有误！");
            }
        }

        return flag;
    }
</script>
</head>

<body>
    <form class="form-horizontal" id="memberForm" action="${ctx}/member/update/${memberVo.id}" method="post">
        <input type="hidden" name="id" value="${memberVo.id}">
        <div class="row text-left col-md-12">
            <span class="col-md-2 text-right">Name: </span>
            <label class="col-md-4"><c:out value="${memberVo.name}"></c:out></label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Pdc Id: </span>
            <label class="col-md-4"><c:out value="${memberVo.pdcId}"></c:out></label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Gender: </span>
            <label class="col-md-4">
                <input type="radio" class="checkbox-inline" name="gender" value="男" <c:choose> <c:when test="${memberVo.gender=='男'}"> checked </c:when> </c:choose> /> 男 
                <input type="radio" class="checkbox-inline" name="gender" value="女" <c:choose> <c:when test="${memberVo.gender=='女'}"> checked </c:when> </c:choose> /> 女
                <input type="radio" class="checkbox-inline" name="gender" value="未知" <c:choose> <c:when test="${memberVo.gender=='未知'}"> checked </c:when> </c:choose> /> 保密
            </label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Role Code: </span>
            <label class="col-md-4"><c:out value="${memberVo.roleCode}"></c:out></label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Supervisor Id: </span>
            <label class="col-md-4">
                <input class="form-control input-sm" name="supervisorId" id="supervisorId" type="text" value="<c:out value='${memberVo.supervisorId}'></c:out>" />
            </label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Backup: </span>
            <label class="col-md-4">
                <select name="backup" class="form-control input-sm">
                    <option value="true" 
                        <c:if test="${memberVo.backup == true}">
                            selected="selected" 
                        </c:if>
                     class="">true</option>
                    <option value="false" 
                        <c:if test="${memberVo.backup == false}">
                            selected="selected" 
                        </c:if>
                     class="">false</option>
                </select>
            </label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Phone: </span>
            <label class="col-md-4">
                <input class="form-control input-sm" name="phone" id="phone" type="text" value="${memberVo.phone}" />
            </label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Register Date: </span>
            <label class="col-md-4"><c:out value="${memberVo.registerDate}"></c:out></label>
        </div>
        <div class="row text-center col-md-6 margin_top_1_persent">
            <button class="btn btn-default" type="button" onclick="javascript: updateMember();">提交</button>
        </div>
        <div class="row col-md-12 margin_top_1_persent"></div>
    </form>

</body>
</html>