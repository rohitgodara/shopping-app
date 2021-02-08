package com.shop.service;

import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shop.data.DummyData;
import com.shop.dto.GenericServiceResponseDTO;
import com.shop.entity.Bill;
import com.shop.entity.Purchase;
import com.shop.exception.DataNotFoundException;
import com.shop.response.wrapper.BillResponseWrapper;

@Service
public class BillService {

	public GenericServiceResponseDTO<BillResponseWrapper> create(int id) {
		return Optional.ofNullable(getPurchaseById(id)).map(purchase -> {
			return new GenericServiceResponseDTO<>(new BillResponseWrapper(generate(purchase)));
		}).orElseThrow(() -> new DataNotFoundException("No Purchase data found for id :: " + id));
	}

	private Bill generate(Purchase purchase) {
		removePurchase(purchase.getId());
		return new Bill.Builder(purchase.getId()).purchase(purchase).build();
	}

	private void removePurchase(int id) {
		DummyData.purchaseList.remove(id - 1);
	}

	private Purchase getPurchaseById(int id) {
		try {
			return DummyData.purchaseList.stream().filter(purchase -> purchase.getId() == id)
					.collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			throw new DataNotFoundException("Purchase details not found for id :: " + id);
		}
	}
}
