package com.meituan.waimai.common.exception;

import com.meituan.waimai.common.api.IErrorCode;

public class AutoTokenException  extends RuntimeException  {

	private IErrorCode errorCode;

	public AutoTokenException(IErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public AutoTokenException(String message) {
		super(message);
	}

	public AutoTokenException(Throwable cause) {
		super(cause);
	}

	public AutoTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	public IErrorCode getErrorCode() {
		return errorCode;
	}
}
