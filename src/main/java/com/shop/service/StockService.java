package com.shop.service;

import org.springframework.stereotype.Service;

import com.shop.data.DummyData;
import com.shop.dto.GenericServiceResponseDTO;
import com.shop.response.wrapper.StockResponseWrapper;

@Service
public class StockService {

	public GenericServiceResponseDTO<StockResponseWrapper> getProducts() {
		return new GenericServiceResponseDTO<>(new StockResponseWrapper(DummyData.newStocklist));
	}

}
