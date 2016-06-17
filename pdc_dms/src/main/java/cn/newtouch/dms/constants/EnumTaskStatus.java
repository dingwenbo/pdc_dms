package cn.newtouch.dms.constants;

/**
 * 任务状态的枚举对象。
 * 
 * @author JiaLong.Wang
 *
 */
public enum EnumTaskStatus {
	
	TODO(1, "TODO"),
	IN_PROGRESSING(2, "In Progressing"),
	PENDING(3, "Pending"),
	FINISHED(4, "Finished");
	
	private Integer id;
	private String code;
	
	private EnumTaskStatus(Integer id, String code) {
		this.id = id;
		this.code = code;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}
