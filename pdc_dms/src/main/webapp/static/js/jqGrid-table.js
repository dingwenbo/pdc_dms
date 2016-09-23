/*jqGrid_table version 1.1
 * 2016-09-23 17:05
 * 
 * */
JqGrid_Table = function(id) {
    this.id = id;
}

JqGrid_Table.prototype.handleJqGridTable = function(fn) {
    if (typeof fn == "function") {
        this.jqGridModel = fn(this.jqGridModel);
    }
};

JqGrid_Table.prototype.jqGrid = function() {
    $("#" + this.id).jqGrid(this.jqGridModel);
}

JqGrid_Table.prototype.jqGridModel = {
    url : "",
    width : 900,
    height : 250,
    mtype : "POST",
    datatype : "json",
    colNames : [],
    colModel : [],
    rownumbers : true,
    rowNum : 10,
    rowList : [],
    pager : "",
    viewrecords : true,
    caption : "",
    footerrow : false,
    editurl : "",
    loadonce : true,
    sortable : true
}

JqGrid_Table.prototype.initModel = function() {
    return [];
}

JqGrid_Table.prototype.getColModel = function() {
    return this.jqGridModel.colModel;
}

JqGrid_Table.prototype.updateColModel = function(colModel) {
    this.jqGridModel.colModel = colModel;
}

JqGrid_Table.prototype.updateColNames = function(colNames) {
    this.jqGridModel.colNames = colNames;
}

JqGrid_Table.prototype.updateRowList = function(rowList) {
    this.jqGridModel.rowList = rowList;
}

JqGrid_Table.prototype.newColModel = function() {
    var model = {
            name : "",
            index : "",
            width : "350",
            align : "left",
            editable : true,
            hidden : false,
            edittype : "",
            stype : ""
    }
    var length = this.jqGridModel.colModel.length;
    this.jqGridModel.colModel[length] = model;
    return model;
}
