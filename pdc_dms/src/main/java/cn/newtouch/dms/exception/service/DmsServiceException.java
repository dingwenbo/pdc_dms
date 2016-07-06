/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.exception.service;

import cn.newtouch.dms.exception.DmsRuntimeException;

/**
 * Service层公用的Exception.
 * 
 * 继承自RuntimeException, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * 
 * @author calvin
 */
public class DmsServiceException extends DmsRuntimeException {

	private static final long serialVersionUID = 3583566093089790852L;

	public DmsServiceException() {
		super();
	}

	public DmsServiceException(String message) {
		super(message);
	}

	public DmsServiceException(Throwable cause) {
		super(cause);
	}

	public DmsServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
