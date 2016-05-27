package com.github.elizabetht.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.github.elizabetht.model.Seller;
import com.github.elizabetht.model.Tender;

public interface SellerMapper {
	@Insert("INSERT INTO seller(user_name, password, first_name,last_name,email_address,phone_number,is_active,row_created,address) VALUES(#{userName},#{password},#{firstName},#{lastName},#{email},#{phoneNumber},#{isActive},#{rowCreated},#{address})")
	@Options(useGeneratedKeys=true, keyProperty="sellerId", flushCache=true, keyColumn="seller_id")
	public void addSeller(Seller seller);
	
	@Select("SELECT USER_NAME as userName, SELLER_ID as sellerId FROM seller WHERE USER_NAME = #{userName} AND PASSWORD=#{password}")
	public Seller login(Seller seller);
	
	@Select("SELECT PRODUCT_NAME as productName,BUYER_FK as buyerFk,TENDER_ID as tenderId,REFERENCE_NO as referenceNo,PRODUCT_DESCRIPTION as productDescription,START_TIME as startTime,CLOSE_TIME as closeTime,QUANTITY as quantity,IS_ACTIVE as isActive,ROW_CREATED as rowCreated FROM tender")
	public List<Tender> tendersList();

}
