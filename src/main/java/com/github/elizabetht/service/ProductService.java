package com.github.elizabetht.service;

import java.util.ArrayList;
import java.util.List;

import com.github.elizabetht.model.Product;

public interface ProductService {
	void insertProduct(Product product);

	ArrayList<Product> getAllList();
	List<Product> allProducts();
	Product getProductById(int productId);
}
