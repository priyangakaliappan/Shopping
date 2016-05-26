package com.github.elizabetht.service;

import java.util.ArrayList;

import com.github.elizabetht.model.Product;

public interface ProductService {
	void insertProduct(Product product);

	ArrayList<Product> getAllList();

	
}
