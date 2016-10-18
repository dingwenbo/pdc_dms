package cn.newtouch.dms.entity;

import org.apache.commons.lang3.StringUtils;

public class TaskStatus {
	
    private Integer id;

    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
    	this.code =	StringUtils.trim(code);
    }
}