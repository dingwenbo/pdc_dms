package cn.newtouch.dms.vo.jqgrid;

import java.util.List;

/**
 * The Class JqGrid.
 */
public class JqGrid {
    
    /** The url. */
    private String url;
    
    /** The width. */
    private Integer width;
    
    /** The height. */
    private Integer height;
    
    /** The mtype. */
    private String mtype;
    
    /** The datatype. */
    private String datatype;
    
    /** The col names. */
    private List<String> colNames;
    
    /** The col model. */
    private List<Model> colModel;
    
    /** The rownumbers. */
    private Boolean rownumbers;
    
    /** The row num. */
    private Integer rowNum;
    
    /** The row list. */
    private List<Integer> rowList;
    
    /** The pager. */
    private String pager;
    
    /** The viewrecords. */
    private Boolean viewrecords;
    
    /** The caption. */
    private String caption;
    
    /** The footerrow. */
    private Boolean footerrow;
    
    /** The editurl. */
    private String editurl;
    
    /**
     * Instantiates a new jq grid.
     */
    public JqGrid() {
        this.mtype = "POST";
        this.datatype = "json";
    }
    
    /**
     * Instantiates a new jq grid.
     *
     * @param caption the caption
     * @param url the url
     * @param width the width
     * @param height the height
     * @param mtype the mtype
     * @param datatype the datatype
     */
    public JqGrid(String caption, String url, Integer width, Integer height, String mtype, String datatype) {
        this();
        this.caption = caption;
        this.url = url;
        this.width = width;
        this.height = height;
        this.mtype = mtype;
        this.datatype = datatype;
    }
    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * Sets the url.
     *
     * @param url the new url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * Gets the width.
     *
     * @return the width
     */
    public Integer getWidth() {
        return width;
    }
    
    /**
     * Sets the width.
     *
     * @param width the new width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }
    
    /**
     * Gets the height.
     *
     * @return the height
     */
    public Integer getHeight() {
        return height;
    }
    
    /**
     * Sets the height.
     *
     * @param height the new height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }
    
    /**
     * Gets the mtype.
     *
     * @return the mtype
     */
    public String getMtype() {
        return mtype;
    }
    
    /**
     * Sets the mtype.
     *
     * @param mtype the new mtype
     */
    public void setMtype(String mtype) {
        this.mtype = mtype;
    }
    
    /**
     * Gets the datatype.
     *
     * @return the datatype
     */
    public String getDatatype() {
        return datatype;
    }
    
    /**
     * Sets the datatype.
     *
     * @param datatype the new datatype
     */
    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }
    
    /**
     * Gets the col names.
     *
     * @return the col names
     */
    public List<String> getColNames() {
        return colNames;
    }
    
    /**
     * Sets the col names.
     *
     * @param colNames the new col names
     */
    public void setColNames(List<String> colNames) {
        this.colNames = colNames;
    }
    
    /**
     * Gets the col model.
     *
     * @return the col model
     */
    public List<Model> getColModel() {
        return colModel;
    }
    
    /**
     * Sets the col model.
     *
     * @param colModel the new col model
     */
    public void setColModel(List<Model> colModel) {
        this.colModel = colModel;
    }
    
    /**
     * Gets the rownumbers.
     *
     * @return the rownumbers
     */
    public Boolean getRownumbers() {
        return rownumbers;
    }
    
    /**
     * Sets the rownumbers.
     *
     * @param rownumbers the new rownumbers
     */
    public void setRownumbers(Boolean rownumbers) {
        this.rownumbers = rownumbers;
    }
    
    /**
     * Gets the row num.
     *
     * @return the row num
     */
    public Integer getRowNum() {
        return rowNum;
    }
    
    /**
     * Sets the row num.
     *
     * @param rowNum the new row num
     */
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }
    
    /**
     * Gets the row list.
     *
     * @return the row list
     */
    public List<Integer> getRowList() {
        return rowList;
    }
    
    /**
     * Sets the row list.
     *
     * @param rowList the new row list
     */
    public void setRowList(List<Integer> rowList) {
        this.rowList = rowList;
    }
    
    /**
     * Gets the pager.
     *
     * @return the pager
     */
    public String getPager() {
        return pager;
    }
    
    /**
     * Sets the pager.
     *
     * @param pager the new pager
     */
    public void setPager(String pager) {
        this.pager = pager;
    }
    
    /**
     * Gets the viewrecords.
     *
     * @return the viewrecords
     */
    public Boolean getViewrecords() {
        return viewrecords;
    }
    
    /**
     * Sets the viewrecords.
     *
     * @param viewrecords the new viewrecords
     */
    public void setViewrecords(Boolean viewrecords) {
        this.viewrecords = viewrecords;
    }
    
    /**
     * Gets the caption.
     *
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }
    
    /**
     * Sets the caption.
     *
     * @param caption the new caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * Gets the footerrow.
     *
     * @return the footerrow
     */
    public Boolean getFooterrow() {
        return footerrow;
    }
    
    /**
     * Sets the footerrow.
     *
     * @param footerrow the new footerrow
     */
    public void setFooterrow(Boolean footerrow) {
        this.footerrow = footerrow;
    }
    
    /**
     * Gets the editurl.
     *
     * @return the editurl
     */
    public String getEditurl() {
        return editurl;
    }
    
    /**
     * Sets the editurl.
     *
     * @param editurl the new editurl
     */
    public void setEditurl(String editurl) {
        this.editurl = editurl;
    }
    
    
}
