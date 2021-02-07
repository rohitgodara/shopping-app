package com.shop.entity;

import java.math.BigDecimal;
import java.util.List;

public final class Purchase {

	private int id;

	private String buyerName;

	private BigDecimal totalAmount;

	private List<Product> products;

	public static class Builder {

		private int id;

		private String buyerName;

		private BigDecimal totalAmount;

		private List<Product> products;

		public Builder(int id) {
			this.id = id;
		}

		public Builder buyerName(String buyerName) {
			this.buyerName = buyerName;
			return this;
		}

		public Builder totalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
			return this;
		}

		public Builder products(List<Product> products) {
			this.products = products;
			return this;
		}

		public Purchase build() {
			return new Purchase(this);
		}

	}

	private Purchase(Builder builder) {
		super();
		this.id = builder.id;
		this.buyerName = builder.buyerName;
		this.totalAmount = builder.totalAmount;
		this.products = builder.products;
	}

	public int getId() {
		return id;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public List<Product> getProducts() {
		return products;
	}

}
