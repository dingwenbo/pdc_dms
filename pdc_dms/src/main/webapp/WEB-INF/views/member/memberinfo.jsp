<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的档案</title>
<link href="${ctx}/static/styles/menu.css" rel="stylesheet">

<script type="text/javascript">
    $(document).ready(function(){
        $("#phone").blur(function(){
            if(!validatePhone()){
                $("#phoneErr").removeClass("hidden");
            }else{
                $("#phoneErr").addClass("hidden");
            }
        });
        $("#email").blur(function(){
            if(!validateEmail()){
                $("#emailErr").removeClass("hidden");
            }else{
                $("#emailErr").addClass("hidden");
            }
        });

        // init form
        initFormData("memberForm");
    });

    function updateMember() {
        if (validateMemberForm()) {
            $("#memberForm").submit();
        }
    }

    function validateMemberForm() {
        if(!validatePhone()){
            dmsAlert("电话号码输入有误！");
            return false;
        }
        if(!validateEmail()){
            dmsAlert("Email 输入有误！");
            return false;
        }
        return true;
    }

    function validatePhone(){
        var phoneTrim = /\s+/g;
        var phoneReg = /^1[3|4|5|7|8]\d{9}$/;
        var phone = $("#phone").val().replace(phoneTrim, '');
        
        if (null != phone && "" != phone && !phoneReg.test(phone)) {
            return false;
        }
        return true;
    }

    function validateEmail(){
        var emailReg = /\w+[@]{1}\w+[.]\w+/;
        var email = $("#email").val();
        
        if (null != email && "" != email && !emailReg.test(email)) {
            return false;
        }
        return true;
    }

    function checkChanged(){
        if (checkFormChanged("memberForm")) {
            $("#updateMemberBtn").removeAttr('disabled');
            $("#updateMemberBtn").addClass('btn-dms-default');
        } else {
            $("#updateMemberBtn").attr('disabled',true);
            $("#updateMemberBtn").removeClass('btn-dms-default');
        }
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
            <div class="col-md-4">
                <input type="radio" class="checkbox-inline" name="gender" onchange="javascript: checkChanged();" value="男" <c:choose> <c:when test="${memberVo.gender=='男'}"> checked </c:when> </c:choose> /> 男 
                <input type="radio" class="checkbox-inline" name="gender" onchange="javascript: checkChanged();" value="女" <c:choose> <c:when test="${memberVo.gender=='女'}"> checked </c:when> </c:choose> /> 女
                <input type="radio" class="checkbox-inline" name="gender" onchange="javascript: checkChanged();" value="未知" <c:choose> <c:when test="${memberVo.gender=='未知'}"> checked </c:when> </c:choose> /> 保密
            </div>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Role Code: </span>
            <label class="col-md-4"><c:out value="${memberVo.roleCode}"></c:out></label>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Phone: </span>
            <label class="col-md-4">
                <input class="form-control input-sm" name="phone" id="phone" type="text" value="${memberVo.phone}" onblur="javascript: checkChanged();" />
            </label>
            <span class="col-md-4 dms_warning_info hidden" id="phoneErr">* 电话号码输入有误</span>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Email: </span>
            <label class="col-md-4">
                <input class="form-control input-sm" name="email" id="email" type="text" value="${memberVo.email}" onblur="javascript: checkChanged();" />
            </label>
            <span class="col-md-4 dms_warning_info hidden" id="emailErr">* Email 输入有误</span>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">Register Date: </span>
            <label class="col-md-4"><c:out value="${memberVo.registerDate}"></c:out></label>
        </div>
        <div class="row text-center col-md-12 margin_top_1_persent">
            <label class="col-md-2"></label>
            <div class="col-md-4 text-left">
                <button class="btn" disabled="disabled" type="button" id="updateMemberBtn" onclick="javascript: updateMember();">提交</button>
            </div>
        </div>
        <div class="row col-md-12 margin_top_1_persent"></div>
    </form>

</body>
</html>