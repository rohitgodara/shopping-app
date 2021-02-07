package com.shop.response.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockResponseWrapper extends BaseResponseWrapper {

	private static final long serialVersionUID = 1L;

	@JsonProperty("New Stock")
	private List<String> stock;

	public StockResponseWrapper(List<String> stock) {
		super();
		this.stock = stock;
	}

	public List<String> getStock() {
		return stock;
	}

	public void setStock(List<String> stock) {
		this.stock = stock;
	}

}
