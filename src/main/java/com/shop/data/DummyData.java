package com.shop.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shop.entity.Product;
import com.shop.entity.Purchase;

public class DummyData {


	public static List<Product> products = Arrays.asList(
			new Product.Builder(1).name("Soda").quantity(10).amount(BigDecimal.valueOf(20)).build(),
			new Product.Builder(2).name("Pepsi").quantity(2).amount(BigDecimal.valueOf(80)).build(),
			new Product.Builder(3).name("Cheese").quantity(3).amount(BigDecimal.valueOf(350)).build(),
			new Product.Builder(4).name("Pen").quantity(1).amount(BigDecimal.valueOf(20)).build());
	
	public static List<Purchase> purchaseList = new ArrayList<>();
	
	public static List<String> newStocklist  = new ArrayList<>();
}
