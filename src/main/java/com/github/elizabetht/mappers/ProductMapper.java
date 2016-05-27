package com.github.elizabetht.mappers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Product;
import com.github.elizabetht.model.Seller;

public interface ProductMapper {

	
	@Insert("INSERT INTO product(product_name, is_active, row_created,image) VALUES(#{productName},#{isActive},#{rowCreated},#{image})")
	@Options(useGeneratedKeys=true, keyProperty="productId", flushCache=true, keyColumn="product_id")
	public void insertProduct(Product product);

	
	@Select("SELECT PRODUCT_NAME as productName, ROW_CREATED as rowCreated FROM product")
	public ArrayList<Product> getProductList();
	
	@Select("SELECT PRODUCT_NAME as productName,PRODUCT_ID as productId,IS_ACTIVE as isActive,ROW_CREATED as rowCreated,IMAGE as image FROM product")
	public List<Product> productsList();
	
	@Select("SELECT PRODUCT_NAME as productName,PRODUCT_ID as productId,IS_ACTIVE as isActive,ROW_CREATED as rowCreated,IMAGE as image FROM product WHERE PRODUCT_ID = #{productId}")
	public Product getProductById(int productId);
	
	@Insert("INSERT INTO seller(user_name, password, first_name,last_name,email_address,phone_number,is_active,row_created,address) VALUES(#{userName},#{password},#{firstName},#{lastName},#{email},#{phoneNumber},#{isActive},#{rowCreated},#{address})")
	@Options(useGeneratedKeys=true, keyProperty="sellerId", flushCache=true, keyColumn="seller_id")
	public void addSeller(Seller seller);
	
	@Select("SELECT USER_NAME as userName, SELLER_ID as sellerId FROM seller WHERE USER_NAME = #{userName} AND PASSWORD=#{password}")
	public Seller login(Seller seller);

}