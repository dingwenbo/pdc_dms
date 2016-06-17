package cn.newtouch.dms.constants;

/**
 * 任务状态的枚举对象。
 * 
 * @author JiaLong.Wang
 *
 */
public enum EnumTaskStatus {
	
	TODO("TODO"),
	IN_PROGRESSING("In Progressing"),
	PENDING("Pending"),
	FINISHED("Finished");
	
	private String code;
	private String label;
	
	private EnumTaskStatus(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
}
