package com.shop.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
		final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex.getMessage());
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ DataNotFoundException.class })
	public ResponseEntity<Object> handleDataNotFoundException(final Exception ex, final WebRequest request) {
		final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), "DATA_NOT_FOUND");
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ NotEnoughQuantityException.class })
	public ResponseEntity<Object> handleNotEnoughQuantityException(final Exception ex, final WebRequest request) {
		final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), "NOT_ENOUGH_QUANTITY_AVAILABLE");
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ ItemNotAvailableException.class })
	public ResponseEntity<Object> handleItemNotAvailableException(final Exception ex, final WebRequest request) {
		final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), "ITEM_NOT_AVAILABLE");
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}
}
