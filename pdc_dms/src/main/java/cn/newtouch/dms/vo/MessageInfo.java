package cn.newtouch.dms.vo;

public class MessageInfo {

	private String code;
	
	private String messageInfo;
	
	public MessageInfo(){}

	public MessageInfo(String code, String messageInfo) {
		this.code = code;
		this.messageInfo = messageInfo;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}
	
	
}
