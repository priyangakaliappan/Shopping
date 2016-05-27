package com.github.elizabetht.mappers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.github.elizabetht.model.Product;

public interface ProductMapper {

	
	@Insert("INSERT INTO product(product_name, is_active, row_created,image) VALUES(#{productName},#{isActive},#{rowCreated},#{image})")
	@Options(useGeneratedKeys=true, keyProperty="productId", flushCache=true, keyColumn="product_id")
	public void insertProduct(Product product);

	
	@Select("SELECT PRODUCT_NAME as productName, ROW_CREATED as rowCreated FROM product")
	public ArrayList<Product> getProductList();
	
	@Select("SELECT PRODUCT_NAME as productName,PRODUCT_ID as productId,IS_ACTIVE as isActive,ROW_CREATED as rowCreated,IMAGE as image FROM product")
	public List<Product> productsList();
	
	@Select("SELECT PRODUCT_NAME as productName,PRODUCT_ID as productId,IS_ACTIVE as isActive,ROW_CREATED as rowCreated FROM product WHERE PRODUCT_ID = #{productId}")
	public Product getProductById(int productId);

}