package com.github.elizabetht.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.mappers.ProductMapper;
import com.github.elizabetht.mappers.StudentMapper;
import com.github.elizabetht.model.Product;
import com.github.elizabetht.model.Student;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	
	@Transactional
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		productMapper.insertProduct(product);
	}


	public ArrayList<Product> getAllList() {
		// TODO Auto-generated method stub
		ArrayList<Product> productList = productMapper.getProductList();
		return productList;
	}
}
