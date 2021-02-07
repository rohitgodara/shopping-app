package com.shop.service;

import org.springframework.stereotype.Service;

import com.shop.data.DummyData;
import com.shop.dto.GenericServiceResponseDTO;
import com.shop.response.wrapper.ProductResponseWrapper;

@Service
public class ProductService {

	public GenericServiceResponseDTO<ProductResponseWrapper> getProducts() {
		return new GenericServiceResponseDTO<>(new ProductResponseWrapper(DummyData.products));
	}

}
