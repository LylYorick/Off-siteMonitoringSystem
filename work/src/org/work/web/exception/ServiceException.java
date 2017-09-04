package org.work.web.exception;

/**
 * 业务异常
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1;
	public ServiceException(Throwable cause) {
		super(cause);
	}
	public ServiceException(String msg) {
		super(msg);
	}
	public ServiceException(String code, String msg) {
		super(msg);
	}
	protected ServiceException() {}
	
}
