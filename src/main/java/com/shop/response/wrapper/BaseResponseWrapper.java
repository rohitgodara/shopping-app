package com.shop.response.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseResponseWrapper implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private String responseStatus;

	public BaseResponseWrapper() {
		super();
	}

	public BaseResponseWrapper(String responseStatus) {
		super();
		this.responseStatus = responseStatus;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

}
