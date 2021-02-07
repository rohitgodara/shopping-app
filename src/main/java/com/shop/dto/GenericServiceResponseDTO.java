package com.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.response.wrapper.BaseResponseWrapper;

public class GenericServiceResponseDTO<T extends BaseResponseWrapper> {

	
	@JsonProperty("Data")
	T data;

	public GenericServiceResponseDTO(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
	
	
}
