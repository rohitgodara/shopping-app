package com.shop.request.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.request.PurchaseRequest;

public class PurchaseRequestWrapper {

	@JsonProperty("Purchase")
	private PurchaseRequest purchase;

	public PurchaseRequestWrapper() {
		super();
	}

	public PurchaseRequestWrapper(PurchaseRequest purchase) {
		super();
		this.purchase = purchase;
	}

	public PurchaseRequest getPurchase() {
		return purchase;
	}

}
