package com.github.elizabetht.model;

import java.util.Date;

public class Buyer {
	private int buyerId;
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private String email;
	private String address;
	private String password;
	private short isActive;
	private Date rowCreated;
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public short getIsActive() {
		return isActive;
	}
	public void setIsActive(short isActive) {
		this.isActive = isActive;
	}
	public Date getRowCreated() {
		return rowCreated;
	}
	public void setRowCreated(Date rowCreated) {
		this.rowCreated = rowCreated;
	}

}
