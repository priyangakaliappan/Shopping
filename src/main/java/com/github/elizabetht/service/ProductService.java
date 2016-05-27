package com.github.elizabetht.service;

import java.util.ArrayList;
import java.util.List;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Product;
import com.github.elizabetht.model.Seller;

public interface ProductService {
	void insertProduct(Product product);

	ArrayList<Product> getAllList();
	List<Product> allProducts();
	Product getProductById(int productId);
	void addSeller(Seller seller);
	Seller login(Seller seller);
}
