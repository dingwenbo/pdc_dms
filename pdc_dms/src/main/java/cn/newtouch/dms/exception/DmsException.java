package cn.newtouch.dms.exception;

/**
 * 本系统下的Exception理应继承该类.
 * 
 * @author JiaLong.Wang
 *
 */
public abstract class DmsException extends Exception {
	
	private static final long serialVersionUID = 2968954545249259347L;

	public DmsException() {
	}
	
	public DmsException(String message) {
		super(message);
	}

	public DmsException(String message, Throwable cause) {
		super(message, cause);
	}

	public DmsException(Throwable cause) {
		super(cause);
	}
}
