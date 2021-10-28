package com.meituan.waimai.amap.error;


public class AMapErrorException extends Exception {

	private final  AMapError error;

	private static final String DEFAULT_ERROR_CODE = "1000";

	public AMapErrorException(String message) {
		this(AMapError.builder().errorCode(DEFAULT_ERROR_CODE).errorMsg(message).build());
	}

	public AMapErrorException(AMapError error) {
		super(error.toString());
		this.error = error;
	}

	public AMapErrorException(AMapError error, Throwable cause) {
		super(error.toString(), cause);
		this.error = error;
	}

	public AMapErrorException(Throwable cause) {
		super(cause.getMessage(), cause);
		this.error = AMapError.builder().errorCode(DEFAULT_ERROR_CODE).errorMsg(cause.getMessage()).build();
	}

	public AMapError getError() {
		return error;
	}
}
