/*******************************************************************************
 * 参考文档： http://bootboxjs.com/documentation.html
 * Dialog Options 简要说明 ( * 为必选项)：
 * 1. message(*): 要显示的 message 信息
 * 2. title: 以 <h4> 显示的标题
 * 3. locale: 设置语言环境，默认 en
 * 4. callback(*): 事件调用后执行的函数
 * 5. onEscape: 是否允许使用 ESC 键，默认 true
 * 6. show: dialog 是否立即显示，默认 true
 * 7. closeButton: 右上角的关闭按钮是否显示，默认 true
 * 8. className: 按钮所使用的 css 样式
 * 9. size: 可以调整弹出框的大小，可以为 large/small, 默认 null
 * 10. buttons(*): 要求显示的 button 信息
 *******************************************************************************/

function dmsAlert(message){
    bootbox.dialog({
        message : message,
        onEscape : true,
        locale : 'zh_CN',
        buttons : {
            ok : {
                label : "确定",
                className : "btn-dms-default",
                callback : function() {}
            }
        }
    });
}

function dmsConfirm(message, doOkMethod){
    bootbox.dialog({
        message : message,
        onEscape : true,
        locale : 'zh_CN',
        closeButton : true,
        buttons : {
            cancel : {
                label : "取消",
                className : "btn-default-cancel",
                callback : function(){}
            },
            confirm : {
                label : "确定",
                className : "btn-dms-default",
                callback : function(){
                    if (doOkMethod) {
                        doOkMethod();
                    }
                }
            }
        }
    });
}

/*******************************************************************************
 * 表单操作
 *******************************************************************************/

var dataformInit;
var jsonTextInit;

// 初始化表单数据 
function initFormData(formId) {
    dataformInit = $("#" + formId).serializeArray();
    jsonTextInit = JSON.stringify({ dataform: dataformInit });
}

// 判断表单是否有修改 
function checkFormChanged(formId) {
    var changed = true;
    if (jsonTextInit !== null && formId !== '') {
        var dataform = $("#" + formId).serializeArray();
        var jsonText = JSON.stringify({ dataform: dataform });
        if (jsonTextInit === jsonText) {
            changed = false;
        }
    }
    return changed;
}

