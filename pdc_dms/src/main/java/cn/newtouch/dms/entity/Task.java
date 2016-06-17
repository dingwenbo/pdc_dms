package cn.newtouch.dms.entity;

import cn.newtouch.dms.constants.EnumTaskStatus;

public class Task {
    private Integer id;

    private Integer projectId;

    private String code;

    private String title;

    private EnumTaskStatus status;

    private String percent;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

	public void setStatus(EnumTaskStatus status) {
		this.status = status;
	}
	
	public EnumTaskStatus getStatus() {
		return status;
	}
	
	public void setStatusId(Integer statusId) {
		if (statusId == null) {
			return;
		}
		for (EnumTaskStatus taskStatus : EnumTaskStatus.values()) {
			if (taskStatus.getId().intValue() == statusId.intValue()) {
				this.status = taskStatus;
				return;
			}
		}
	}
	
	public Integer getStatusId() {
		if (status == null) {
			return null;
		}
		return status.getId();
	}
	
    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent == null ? null : percent.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}