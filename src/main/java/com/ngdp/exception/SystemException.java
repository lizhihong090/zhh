package com.ngdp.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;
	private final Map<String, Object> props = new HashMap<String, Object>();
	private final Map<String, Object> contexts = new TreeMap<String, Object>();

	public static SystemException wrap(Throwable exception, ErrorCode errorCode) {
		if (exception instanceof SystemException) {
			SystemException se = (SystemException) exception;
			if (errorCode != null && errorCode != se.getErrorCode()) {
				return new SystemException(exception.getMessage(), exception, errorCode);
			}
			return se;
		} else {

			return new SystemException(exception.getMessage(), exception, errorCode);
		}
	}

	public static SystemException wrap(Throwable exception) {
		return wrap(exception, null);
	}

	public SystemException(String message) {
		this(message, ErrorCode.SERVER_ERROR);
	}
	
	public SystemException(String message, Throwable cause) {
		this(message, cause, ErrorCode.SERVER_ERROR);
	}

	public SystemException(String message, ErrorCode errorCode) {
		this(message, null, errorCode);
	}

	public SystemException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public SystemException setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public Map<String, Object> getContexts() {
		return contexts;
	}

	public Map<String, Object> getProps() {
		return props;
	}

	public SystemException set(String name, Object value) {
		props.put(name, value);
		return this;
	}

	public SystemException setContext(String name, Object value) {
		contexts.put(name, value);
		return this;
	}

	public SystemException setContext(Object value) {
		contexts.put(value.getClass().getSimpleName(), value);
		return this;
	}

}
