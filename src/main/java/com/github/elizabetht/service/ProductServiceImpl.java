package com.github.elizabetht.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.mappers.ProductMapper;
import com.github.elizabetht.mappers.StudentMapper;
import com.github.elizabetht.model.Product;
import com.github.elizabetht.model.Seller;
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
	public List<Product> allProducts() {
		System.out.println("PRODUCT impl:::::::::::::::::::::");
		List<Product> ss = productMapper.productsList();
		System.out.println("SUCCESSSSSSSSSSSSSSSSSSSSSSSS"+ss);
		return ss;
	}

	public Product getProductById(int productId) {
		System.out.println("STUDENT IMPL:::::::::::: "+productId);
		Product product = productMapper.getProductById(productId);
		System.out.println("PRODUCT:::::::::::::::::::::: "+product);
		return product;
	}


}
