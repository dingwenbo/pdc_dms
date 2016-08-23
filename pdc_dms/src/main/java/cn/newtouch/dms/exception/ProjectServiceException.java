package cn.newtouch.dms.exception;

public class ProjectServiceException extends DmsException {

	private static final long serialVersionUID = 2348825006214209274L;
	
	public ProjectServiceException() {
	}
	
	public ProjectServiceException(String message) {
		super(message);
	}
	
	public ProjectServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectServiceException(Throwable cause) {
		super(cause);
	}
}
