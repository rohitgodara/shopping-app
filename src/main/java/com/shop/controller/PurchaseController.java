package com.shop.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shop.dto.GenericServiceResponseDTO;
import com.shop.request.wrapper.PurchaseRequestWrapper;
import com.shop.response.wrapper.PurchaseResponseWrapper;
import com.shop.service.PurchaseService;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@GetMapping(value = "/purchases/{PurchaseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericServiceResponseDTO<PurchaseResponseWrapper>> getProduct(
			@PathVariable("PurchaseId") int purchaseId) {
		GenericServiceResponseDTO<PurchaseResponseWrapper> data = purchaseService.getProduct(purchaseId);
		return ResponseEntity.ok(data);
	}

	@PostMapping(value = "/purchases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericServiceResponseDTO<PurchaseResponseWrapper>> createPurchase(
			@RequestBody PurchaseRequestWrapper request) {

		GenericServiceResponseDTO<PurchaseResponseWrapper> purchaseResponse = purchaseService
				.purchase(request.getPurchase());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{PurchaseId}")
				.buildAndExpand(purchaseResponse.getData().getPurchase().getId()).toUri();

		return ResponseEntity.created(location).body(purchaseResponse);
	}

	@DeleteMapping("/delete/{PurchaseId}")
	public ResponseEntity<GenericServiceResponseDTO<PurchaseResponseWrapper>> delete(
			@PathVariable("PurchaseId") int purchaseId) {
		GenericServiceResponseDTO<PurchaseResponseWrapper> data = purchaseService.delete(purchaseId);
		return ResponseEntity.ok(data);
	}
}
