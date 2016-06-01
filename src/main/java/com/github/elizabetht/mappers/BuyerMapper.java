package com.github.elizabetht.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Tender;
import com.github.elizabetht.model.TenderQuotation;

public interface BuyerMapper {

	@Insert("INSERT INTO buyer(firstname, lastname, email_address, password, phone_number, address, is_active, row_created) VALUES(#{firstname},#{lastname},#{email},#{password},#{phoneNumber},#{address},#{isActive},#{rowCreated})")
	@Options(useGeneratedKeys=true, keyProperty="buyerId", flushCache=true, keyColumn="buyer_id")
	public void insert(Buyer buyer);

	@Select("SELECT BUYER_ID as buyerId, FIRSTNAME as firstname, LASTNAME as lastname, EMAIL_ADDRESS as email FROM buyer WHERE EMAIL_ADDRESS = #{email} AND PASSWORD=#{password}")
	public Buyer login(Buyer buyer);

	@Insert("INSERT INTO tender(reference_no, product_name, product_description, quantity, start_time, close_time, is_active, row_created, buyer_fk) VALUES(#{referenceNo},#{productName},#{productDescription},#{quantity},#{startTime},#{closeTime},#{isActive},#{rowCreated},#{buyerFk})")
	@Options(useGeneratedKeys=true, keyProperty="tenderId", flushCache=true, keyColumn="tender_id")
	public void addTender(Tender tender);
	
	@Select("SELECT BUYER_ID as buyerId, FIRSTNAME as firstname, LASTNAME as lastname, EMAIL_ADDRESS as email FROM buyer WHERE BUYER_ID = #{buyerId}")
	public Buyer getBuyer(int buyerId);

	@Select("SELECT TENDER_FK as tenderFk, PRICE as price, PRODUCT_CONFIGURATION as productConfiguration, ROW_CREATED as rowCreated FROM TENDER_QUOTATION WHERE buyer_fk = #{buyerId}")
	public ArrayList<TenderQuotation> getSellerResponse(int buyerId);

	@Select("select product_name as productName, quantity as quantity from tender where tender_id = #{tenderId}")
	public Tender getTenderById(int tenderId);

	@Select("Select tender_id as tenderId, reference_no as referenceNo, product_name as productName, product_description as productDescription, quantity as quantity, start_time as startTime, close_time as closeTime, is_active as isActive, buyer_fk as buyerFk from tender where buyer_fk = #{buyerId} ")
	public ArrayList<Tender> getTenderList(int buyerId);

	@Update("UPDATE tender SET is_active= 0 where tender_id= #{tenderId}")
	public void suspendTender(int tenderId);
	
	@Update("UPDATE tender SET is_active= 1 where tender_id= #{tenderId}")
	public void activateTender(int tenderId);
}
