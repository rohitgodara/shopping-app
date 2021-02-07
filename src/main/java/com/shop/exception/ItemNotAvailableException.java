package com.shop.exception;

public class ItemNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemNotAvailableException() {
		super();
	}

	public ItemNotAvailableException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ItemNotAvailableException(final String message) {
		super(message);
	}

	public ItemNotAvailableException(final Throwable cause) {
		super(cause);
	}
}
