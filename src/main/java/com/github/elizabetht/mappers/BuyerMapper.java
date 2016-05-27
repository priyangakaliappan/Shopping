package com.github.elizabetht.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.github.elizabetht.model.Buyer;

public interface BuyerMapper {

	@Insert("INSERT INTO buyer(firstname, lastname, email_address, password, phone_number, address, is_active, row_created) VALUES(#{firstname},#{lastname},#{email},#{password},#{phoneNumber},#{address},#{isActive},#{rowCreated})")
	@Options(useGeneratedKeys=true, keyProperty="buyerId", flushCache=true, keyColumn="buyer_id")
	public void insert(Buyer buyer);

	@Select("SELECT EMAIL_ADDRESS as email FROM buyer WHERE EMAIL_ADDRESS = #{email} AND PASSWORD=#{password}")
	public Buyer login(Buyer buyer);

}
