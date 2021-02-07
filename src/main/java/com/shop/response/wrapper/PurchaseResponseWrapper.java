package com.shop.response.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.entity.Purchase;

public class PurchaseResponseWrapper extends BaseResponseWrapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("purchase")
	private Purchase purchase;

	public PurchaseResponseWrapper(Purchase purchase) {
		super();
		this.purchase = purchase;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

}
