package com.shop.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shop.dto.GenericServiceResponseDTO;
import com.shop.response.wrapper.BillResponseWrapper;
import com.shop.service.BillService;

@RestController
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping(value = "/bills/{PurchaseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericServiceResponseDTO<BillResponseWrapper>> createPurchase(
			@PathVariable("PurchaseId") int purchaseId) {

		GenericServiceResponseDTO<BillResponseWrapper> billResponse = billService.create(purchaseId);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{PurchaseId}")
				.buildAndExpand(billResponse.getData().getBill().getId()).toUri();

		return ResponseEntity.created(location).body(billResponse);
	}
	
	
}
