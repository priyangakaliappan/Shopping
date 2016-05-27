package com.github.elizabetht.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Tender;

public interface BuyerMapper {

	@Insert("INSERT INTO buyer(firstname, lastname, email_address, password, phone_number, address, is_active, row_created) VALUES(#{firstname},#{lastname},#{email},#{password},#{phoneNumber},#{address},#{isActive},#{rowCreated})")
	@Options(useGeneratedKeys=true, keyProperty="buyerId", flushCache=true, keyColumn="buyer_id")
	public void insert(Buyer buyer);

	@Select("SELECT BUYER_ID as buyerId, FIRSTNAME as firstname, LASTNAME as lastname, EMAIL_ADDRESS as email FROM buyer WHERE EMAIL_ADDRESS = #{email} AND PASSWORD=#{password}")
	public Buyer login(Buyer buyer);

	@Insert("INSERT INTO tender(reference_no, product_name, product_description, quantity, start_time, close_time, is_active, row_created, buyer_fk) VALUES(#{referenceNo},#{productName},#{productDescription},#{quantity},#{startTime},#{closeTime},#{isActive},#{rowCreated},#{buyerFk})")
	@Options(useGeneratedKeys=true, keyProperty="tenderId", flushCache=true, keyColumn="tender_id")
	public void addTender(Tender tender);

}
