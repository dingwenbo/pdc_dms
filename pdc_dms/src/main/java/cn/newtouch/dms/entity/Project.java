package cn.newtouch.dms.entity;

import java.util.List;

/**
 * Class project.
 * <pre>项目的实体类。</pre>
 * 
 * @author WenBo.Ding
 *
 */
public class Project {
	
	/** id. */
    private Integer id;

    /** code. */
    private String code;
    
    /** fullName. */
    private String fullName;

    /** label. */
    private String label;
    
    /** parent. */
    private Project parent;
    
    /** members. */
    private List<Member> members;
    
    public Project() {
    }
    
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
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Project getParent() {
		return parent;
	}

	public void setParent(Project parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", code=" + code + ", fullName=" + fullName + ", label=" + label + ", parent="
				+ parent + "]";
	}
}