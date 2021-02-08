package com.shop.entity;

public final class Bill {

	private int id;

	private Purchase purchase;

	public static class Builder {
		private int id;

		private Purchase purchase;

		public Builder(int id) {
			super();
			this.id = id;
		}

		public Builder purchase(Purchase purchase) {
			this.purchase = purchase;
			return this;
		}

		public Bill build() {
			return new Bill(this);
		}
	}

	private Bill(Builder builder) {
		this.id = builder.id;
		this.purchase = builder.purchase;
	}

	public int getId() {
		return id;
	}

	public Purchase getPurchase() {
		return purchase;
	}

}
