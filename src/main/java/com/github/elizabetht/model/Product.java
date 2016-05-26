package com.github.elizabetht.model;

import java.util.Date;

public class Product {

private int productId;
private String productName;
private String image;
private short isActive;
private Date rowCreated;

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
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
private Date rowAltered;
}
