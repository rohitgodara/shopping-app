package com.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Quantity")
	private int quantity;

	public ProductDto(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

}
