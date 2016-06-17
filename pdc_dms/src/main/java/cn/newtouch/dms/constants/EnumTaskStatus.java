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
	
	private EnumTaskStatus(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
