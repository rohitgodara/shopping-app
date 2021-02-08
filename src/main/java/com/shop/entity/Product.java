package com.shop.entity;

import java.math.BigDecimal;

public final class Product {

	private int id;
	private String name;
	private int quantity;
	private BigDecimal amount;

	public static class Builder {

		private int id;

		private String name;

		private int quantity;

		private BigDecimal amount;

		public Builder(int id) {
			this.id = id;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder quantity(int quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Product build() {
			return new Product(this);
		}

	}

	private Product(Builder builder) {
		super();
		this.id = builder.id;
		this.name = builder.name;
		this.quantity = builder.quantity;
		this.amount = builder.amount;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", amount=" + amount + "]";
	}

}
