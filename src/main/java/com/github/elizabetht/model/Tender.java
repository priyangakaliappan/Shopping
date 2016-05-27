package com.github.elizabetht.model;

import java.util.Date;

public class Tender {

private int tenderId;
private int buyerFk;
private String referenceNo;
private String productName;
private String productDescription;
private int quantity;
private Date startTime;
private Date closeTime;
private short isActive;
private Date rowCreated;
private Date rowAltered;

public int getTenderId() {
	return tenderId;
}
public void setTenderId(int tenderId) {
	this.tenderId = tenderId;
}
public int getBuyerFk() {
	return buyerFk;
}
public void setBuyerFk(int buyerFk) {
	this.buyerFk = buyerFk;
}
public String getReferenceNo() {
	return referenceNo;
}
public void setReferenceNo(String referenceNo) {
	this.referenceNo = referenceNo;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Date getStartTime() {
	return startTime;
}
public void setStartTime(Date startTime) {
	this.startTime = startTime;
}
public Date getCloseTime() {
	return closeTime;
}
public void setCloseTime(Date closeTime) {
	this.closeTime = closeTime;
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
