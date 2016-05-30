package com.github.elizabetht.model;

import java.util.Date;


public class Seller {
	private int sellerId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String address;	
	private short isActive;
	private Date rowCreated;
	private Date rowAltered;
	
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Date getRowAltered() {
		return rowAltered;
	}
	public void setRowAltered(Date rowAltered) {
		this.rowAltered = rowAltered;
	}
	

}
