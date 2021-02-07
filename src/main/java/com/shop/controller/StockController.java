package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.GenericServiceResponseDTO;
import com.shop.response.wrapper.StockResponseWrapper;
import com.shop.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericServiceResponseDTO<StockResponseWrapper>> getNewStocks() {
		GenericServiceResponseDTO<StockResponseWrapper> data = stockService.getProducts();
		return ResponseEntity.ok(data);
	}
}
