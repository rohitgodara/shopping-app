package com.shop.response.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.entity.Product;

public class ProductResponseWrapper extends BaseResponseWrapper {

	private static final long serialVersionUID = 1L;

	@JsonProperty("products")
	private List<Product> products;

	public ProductResponseWrapper(List<Product> products) {
		super();
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
