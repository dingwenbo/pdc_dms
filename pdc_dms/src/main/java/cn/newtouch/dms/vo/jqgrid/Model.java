package cn.newtouch.dms.vo.jqgrid;


/**
 * The Class Model.
 */
public class Model {
    
    /** The name. */
    private String name;
    
    /** The index. */
    private String index;
    
    /** The width. */
    private Integer width;
    
    /** The align. */
    private String align;
    
    /** The editable. */
    private Boolean editable;
    
    /** The hidden. */
    private Boolean hidden;
    
    /** The edittype. */
    private String edittype;
    
    /** The stype. */
    private String stype;
    /**
     * Instantiates a new model.
     */
    public Model() {
        
    }
    
    /**
     * Instantiates a new model.
     *
     * @param name the name
     * @param index the index
     * @param width the width
     * @param align the align
     */
    public Model(String name, String index, Integer width, String align) {
        this(name, index, width, align, Boolean.TRUE, Boolean.FALSE, null, null);
    }
    
    /**
     * Instantiates a new model.
     *
     * @param name the name
     * @param index the index
     * @param width the width
     * @param align the align
     * @param edittype the edittype
     */
    public Model(String name, String index, Integer width, String align,  String edittype) {
        this(name, index, width, align, Boolean.TRUE, Boolean.FALSE, edittype, null);
    }

    /**
     * Instantiates a new model.
     * 
     * @param name the name
     * @param index the index
     * @param width the width
     * @param align the align
     * @param edittype the edittype
     * @param stype the stype
     */
    public Model(String name, String index, Integer width, String align,  String edittype, String stype) {
    	this(name, index, width, align, Boolean.TRUE, Boolean.FALSE, edittype, stype);
    }
    
    /**
     * Instantiates a new model.
     *
     * @param name the name
     * @param index the index
     * @param width the width
     * @param align the align
     * @param editable the editable
     * @param hidden the hidden
     * @param edittype the edittype
     * @param stype the stype
     */
    public Model(String name, String index, Integer width, String align, Boolean editable, Boolean hidden, String edittype, String stype) {
        this.name = name;
        this.index = index;
        this.width = width;
        this.align = align;
        this.editable = editable;
        this.hidden = hidden;
        this.edittype = edittype;
        this.stype = stype;
    }
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the index.
     *
     * @return the index
     */
    public String getIndex() {
        return index;
    }
    
    /**
     * Sets the index.
     *
     * @param index the new index
     */
    public void setIndex(String index) {
        this.index = index;
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
     * Gets the align.
     *
     * @return the align
     */
    public String getAlign() {
        return align;
    }
    
    /**
     * Sets the align.
     *
     * @param align the new align
     */
    public void setAlign(String align) {
        this.align = align;
    }
    
    /**
     * Gets the editable.
     *
     * @return the editable
     */
    public Boolean getEditable() {
        return editable;
    }
    
    /**
     * Sets the editable.
     *
     * @param editable the new editable
     */
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
    
    /**
     * Gets the hidden.
     *
     * @return the hidden
     */
    public Boolean getHidden() {
        return hidden;
    }
    
    /**
     * Sets the hidden.
     *
     * @param hidden the new hidden
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
    
    /**
     * Gets the edittype.
     *
     * @return the edittype
     */
    public String getEdittype() {
        return edittype;
    }
    
    /**
     * Sets the edittype.
     *
     * @param edittype the new edittype
     */
    public void setEdittype(String edittype) {
        this.edittype = edittype;
    }

	/**
	 * Gets the stype
	 * 
	 * @return the stype
	 */
	public String getStype() {
		return stype;
	}

	/**
	 * Sets the stype
	 * 
	 * @param stype the new stype
	 */
	public void setStype(String stype) {
		this.stype = stype;
	}
}
