package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.GenericServiceResponseDTO;
import com.shop.response.wrapper.ProductResponseWrapper;
import com.shop.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericServiceResponseDTO<ProductResponseWrapper>> getProducts() {
		GenericServiceResponseDTO<ProductResponseWrapper> data = productService.getProducts();
		return ResponseEntity.ok(data);

	}

	

}
