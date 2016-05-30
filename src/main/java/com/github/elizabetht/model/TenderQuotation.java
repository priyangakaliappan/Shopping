package com.github.elizabetht.model;

import java.util.Date;

public class TenderQuotation {

	private int tenderQuotationId;
	private int tenderFk;
	private int buyerFk;
	private String price;
	private String productConfiguration;
	private short isActive;
	private Date rowCreated;
	private Date rowAltered;
	
	public int getTenderQuotationId() {
		return tenderQuotationId;
	}
	public void setTenderQuotationId(int tenderQuotationId) {
		this.tenderQuotationId = tenderQuotationId;
	}
	public int getTenderFk() {
		return tenderFk;
	}
	public void setTenderFk(int tenderFk) {
		this.tenderFk = tenderFk;
	}
	public int getBuyerFk() {
		return buyerFk;
	}
	public void setBuyerFk(int buyerFk) {
		this.buyerFk = buyerFk;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductConfiguration() {
		return productConfiguration;
	}
	public void setProductConfiguration(String productConfiguration) {
		this.productConfiguration = productConfiguration;
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
