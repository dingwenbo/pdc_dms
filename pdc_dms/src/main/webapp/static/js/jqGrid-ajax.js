
function initJqGrid(url, id, updateJqGrid) {
    $.ajax({
        type:"POST",
        async:false, 
        url:url,
        success:function(data){ 
            if (data != null) { 
              var jqGrid = eval("("+data+")");
              if (typeof updateJqGrid == "function") {
                  jqGrid = updateJqGrid(jqGrid);
              }
              
              $('#' + id).jqGrid(jqGrid);
            } 
        }
    }); 
}
