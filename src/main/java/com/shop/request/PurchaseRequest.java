package com.shop.request;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.dto.ProductDto;

public class PurchaseRequest {

	@JsonProperty("BuyerName")
	private String buyerName;

	@JsonProperty("Products")
	private List<ProductDto> products;

	public PurchaseRequest() {
		super();
	}

	public PurchaseRequest(String buyerName, String contact, BigDecimal totalAmount, List<ProductDto> products) {
		super();
		this.buyerName = buyerName;
		this.products = products;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

}
