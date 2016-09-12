function dmsAlert(message){
    bootbox.dialog({
        message : message,
        onEscape : true,
        locale : 'zh_CN',
        buttons : {
            confirm : {
                label : "确定",
                className : "btn-dms-default",
                callback : function() {}
            }
        }
    });
}
