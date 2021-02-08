package com.shop.response.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.entity.Bill;

public class BillResponseWrapper extends BaseResponseWrapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("Bill")
	private Bill bill;

	public BillResponseWrapper(Bill bill) {
		super();
		this.bill = bill;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
