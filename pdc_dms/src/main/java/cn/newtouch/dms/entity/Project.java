package cn.newtouch.dms.entity;

import java.util.List;

/**
 * Class project.
 * @author WenBo.Ding
 *
 */
public class Project {
	/** id. */
    private Integer id;

    /** code. */
    private String code;

    /** label. */
    private String label;
    
    /** members. */
    private List<Member> members;
    
    public Project(String code, String label) {
    	this.code = code;
    	this.label = label;
    }

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
        this.code = code == null ? null : code.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", code=" + code + ", "
				+ "label=" + label + ", members=" + members + "]";
	}
}