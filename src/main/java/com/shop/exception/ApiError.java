package com.shop.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ApiError {

	private HttpStatus status;
	private String statusCode;
	private List<String> errors;
	private String message;
	Date timestamp = new Date(new Timestamp(System.currentTimeMillis()).getTime());

	public ApiError() {
		super();
	}

	public ApiError(final HttpStatus status, final String message, final String error) {
		super();
		this.statusCode = status.toString();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public void setError(final String error) {
		errors = Arrays.asList(error);

	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}