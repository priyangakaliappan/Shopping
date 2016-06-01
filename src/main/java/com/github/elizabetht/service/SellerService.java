package com.github.elizabetht.service;

import java.util.ArrayList;
import java.util.List;

import com.github.elizabetht.model.Seller;
import com.github.elizabetht.model.Tender;
import com.github.elizabetht.model.TenderQuotation;

public interface SellerService {
	void addSeller(Seller seller);
	Seller login(Seller seller);
	List<Tender> getAll();
	ArrayList<Seller> getAllSellers();
	Tender getTender(int id);
	void submitQuotation(TenderQuotation tenderQuotation);
	TenderQuotation getQuotation(int tenderId);

}
