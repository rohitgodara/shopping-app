package com.shop.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DataNotFoundException(final String message) {
		super(message);
	}

	public DataNotFoundException(final Throwable cause) {
		super(cause);
	}
}
