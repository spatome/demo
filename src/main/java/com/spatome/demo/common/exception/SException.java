package com.spatome.demo.common.exception;

public class SException extends RuntimeException {
	private static final long serialVersionUID = 7576132341064220344L;

	private String code;
	
	public SException() {
	}

	public SException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	/*不写堆栈*/
	@Override
	public Throwable fillInStackTrace(){
		return this;
	}
}