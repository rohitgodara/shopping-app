package com.shop.exception;

public class NotEnoughQuantityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughQuantityException() {
		super();
	}

	public NotEnoughQuantityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NotEnoughQuantityException(final String message) {
		super(message);
	}

	public NotEnoughQuantityException(final Throwable cause) {
		super(cause);
	}
}
