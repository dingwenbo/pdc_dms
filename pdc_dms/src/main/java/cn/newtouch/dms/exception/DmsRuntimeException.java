package cn.newtouch.dms.exception;

public class DmsRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8428036427352168163L;

	public DmsRuntimeException() {
		super();
	}

	public DmsRuntimeException(String message) {
		super(message);
	}

	public DmsRuntimeException(Throwable cause) {
		super(cause);
	}

	public DmsRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
