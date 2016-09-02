package cn.newtouch.dms.web.project.bean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import cn.newtouch.dms.entity.Project;
import cn.newtouch.dms.vo.Viewable;

/**
 * 项目详细的视图对象.
 * 
 * @author JiaLong.Wang
 *
 */
public class ProjectDetailVO implements Viewable<Project> {
	
	private String id;
	private String code;
	private String fullName;
	private String label;
	private String parentCode;
	private String oper;
	
	public ProjectDetailVO() {
	}

	public Integer getIdValue() {
		if (StringUtils.isNumeric(id)) {
			return Integer.parseInt(id);
		}
		return null;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	@Override
	public void accept(Project project) {
		BeanUtils.copyProperties(project, this);
		this.setId(String.valueOf(project.getId()));
		if (project.getParent() != null) {
			setParentCode(project.getParent().getCode());
		}
	}
}
