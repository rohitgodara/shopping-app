package com.shop.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shop.data.DummyData;
import com.shop.dto.GenericServiceResponseDTO;
import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.entity.Purchase;
import com.shop.exception.DataNotFoundException;
import com.shop.exception.ItemNotAvailableException;
import com.shop.exception.NotEnoughQuantityException;
import com.shop.request.PurchaseRequest;
import com.shop.response.wrapper.PurchaseResponseWrapper;

@Service
public class PurchaseService {

	public GenericServiceResponseDTO<PurchaseResponseWrapper> purchase(PurchaseRequest request) {
		return Optional.ofNullable(request.getProducts()).map(products -> {
			return new GenericServiceResponseDTO<>(
					new PurchaseResponseWrapper(createPurchaseEntry(products, request.getBuyerName())));
		}).orElseThrow(() -> new DataNotFoundException("Product not found for product"));
	}

	private Purchase createPurchaseEntry(List<ProductDto> products, String buyerName) {
		List<Product> productsInCart = new ArrayList<>();
		BigDecimal totalAmount = BigDecimal.ZERO;
		isStockAvailable(products);
		for (ProductDto reqProduct : products) {
			Product product = getProductByName(reqProduct.getName());
			totalAmount = totalAmount.add(product.getAmount().multiply(BigDecimal.valueOf(reqProduct.getQuantity())));
			productsInCart.add(new Product.Builder(product.getId()).name(product.getName())
					.quantity(reqProduct.getQuantity())
					.amount(product.getAmount().multiply(BigDecimal.valueOf(reqProduct.getQuantity()))).build());
			updateStockForEvent(reqProduct.getName(), reqProduct.getQuantity(), "SELL");
		}
		Purchase purchase = new Purchase.Builder(DummyData.purchaseList.size() + 1).buyerName(buyerName)
				.products(productsInCart).totalAmount(totalAmount).build();
		DummyData.purchaseList.add(purchase);
		return purchase;
	}

	private Product getProductByName(String productName) {
		try {
			return DummyData.products.stream().filter(product -> product.getName().equalsIgnoreCase(productName))
					.collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			throw new DataNotFoundException("Product not found for product :: " + productName);
		}
	}

	private void isStockAvailable(List<ProductDto> products) {
		for (ProductDto reqProduct : products) {
			Product product = getProductByName(reqProduct.getName());
			if (product.getQuantity()==0) {
				throw new ItemNotAvailableException("Item '"+reqProduct.getName()+"' not available");
			}
			if (reqProduct.getQuantity() > product.getQuantity()) {
				throw new NotEnoughQuantityException("Not enough quantity for product :: " + reqProduct.getName());
			}
		}
	}

	private void updateStockForEvent(String productName, int quantity, String event) {
		ListIterator<Product> products = DummyData.products.listIterator();
		while (products.hasNext()) {
			Product product = products.next();
			if (product.getName().equals(productName)) {
				if (event.equalsIgnoreCase("SELL")) {
					product.setQuantity(product.getQuantity() - quantity);
					if(product.getQuantity()==0) {
						DummyData.newStocklist.add(product.getName());
					}
				}
				if (event.equalsIgnoreCase("PURCHASE"))
					product.setQuantity(product.getQuantity() + quantity);
				break;
			}
		}
	}

	public GenericServiceResponseDTO<PurchaseResponseWrapper> getProduct(int purchaseId) {
		try {
			return new GenericServiceResponseDTO<>(
					new PurchaseResponseWrapper(DummyData.purchaseList.get(purchaseId - 1)));
		} catch (Exception e) {
			throw new DataNotFoundException("No data found for given purchase purchase id :: " + purchaseId);
		}
	}
}
