<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改密码</title>
<link href="${ctx}/static/styles/menu.css" rel="stylesheet">

<script type="text/javascript">
    var passwordFlag = false;
    var newPasswordFlag = false;
    var confirmPasswordFlag = false;

    function validatePassword(){
        $('#pwdErr').html('');
        $.ajax({
            type: 'POST',
            url: '${ctx}/member/validatePassword',
            data: {'password': $('#pwd').val()},
            async: true,
            dataType: 'json',
            success: function(data){
                if(data === "true"){
                    passwordFlag = true;
                    $('#pwdErr').addClass('hidden');
                } else {
                    passwordFlag = false;
                    $('#pwdErr').removeClass('hidden');
                    $('#pwdErr').append("<span class='dms_warning_info'>* 原密码输入不正确</span>");
                }
            }
        });
    }

    function validateNewPassword(){
        $('#newPwdErr').html('');
        var newPassword = $('#newPwd').val();
        if(newPassword !== ''){
            newPasswordFlag = true;
            $('#newPwdErr').addClass('hidden');
        } else {
            newPasswordFlag = false;
            $('#newPwdErr').removeClass('hidden');
            $('#newPwdErr').append("<span class='dms_warning_info'>* 请输入新密码</span>");
        }
    }

    function validateConfirmPassword(){
        $('#confirmPwdErr').html('');
        var newPassword = $('#newPwd').val();
        var confirmPassword = $('#confirmPwd').val();
        if(newPassword === confirmPassword){
            confirmPasswordFlag = true;
            $('#confirmPwdErr').addClass('hidden');
        } else {
            confirmPasswordFlag = false;
            $('#confirmPwdErr').removeClass('hidden');
            $('#confirmPwdErr').append("<span class='dms_warning_info'>* 确认密码不正确</span>");
        }
    }

    function modifyPassword(){
        $('#message').html('');
        if(passwordFlag && newPasswordFlag && confirmPasswordFlag){
            $.ajax({
                type: 'POST',
                url: '${ctx}/member/modifyPassword',
                data: {'confirmPassword': $('#confirmPwd').val()},
                async: true,
                dataType: 'json',
                success: function(data){
                    if(data === "true"){
                        clearForm();
                        $('#message').append('<label class="text-success">密码更新成功！</label>');
                    }
                }
            });
        } else if (!passwordFlag){
            dmsAlert("原密码输入不正确!");
        } else if (!newPasswordFlag){
            dmsAlert("请输入新密码!");
        } else if (!confirmPasswordFlag){
            dmsAlert("确认密码不正确!");
        }
    }

    function clearForm(){
        $('#pwd').val('');
        $('#newPwd').val('');
        $('#confirmPwd').val('');
    }
</script>
</head>

<body>
    <form class="form-horizontal" id="modifyPasswordForm">
        <div class="row text-right col-md-2" id="message"></div>
        <div class="row text-left col-md-12">
            <span class="col-md-2 text-right">原密码: </span>
            <div class="col-md-4">
                <input type="password" class="form-control input-sm" id="pwd" name="password" maxlength="30" onblur="javacript: validatePassword();" />
            </div>
            <div class="col-md-4" id="pwdErr"></div>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">新密码: </span>
            <div class="col-md-4">
                <input type="password" class="form-control input-sm" id="newPwd" name="newPassword" maxlength="30" onblur="javacript: validateNewPassword();" />
            </div>
            <div class="col-md-4" id="newPwdErr"></div>
        </div>
        <div class="row text-left col-md-12 margin_top_1_persent">
            <span class="col-md-2 text-right">确认密码: </span>
            <div class="col-md-4">
                <input type="password" class="form-control input-sm" id="confirmPwd" name="confirmPassword" maxlength="30" onblur="javascript: validateConfirmPassword();" />
            </div>
            <div class="col-md-4" id="confirmPwdErr"></div>
        </div>
        <div class="row text-center col-md-6 margin_top_1_persent">
            <button class="btn btn-dms-default" type="button" id="modifyPasswordBtn" onclick="javascript: modifyPassword();">修改</button>
        </div>
        <div class="row col-md-12 margin_top_1_persent"></div>
    </form>

</body>
</html>