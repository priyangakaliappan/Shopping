package com.github.elizabetht.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.github.elizabetht.model.Product;

public interface ProductMapper {

	
	@Insert("INSERT INTO product(product_name, is_active, row_created) VALUES(#{productName},#{isActive},#{rowCreated})")
	@Options(useGeneratedKeys=true, keyProperty="productId", flushCache=true, keyColumn="product_id")
	public void insertStudent(Product product);

	
	@Select("SELECT PRODUCT_NAME as productName, ROW_CREATED as rowCreated FROM product")
	public ArrayList<Product> getProductList();

}