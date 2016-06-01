package com.github.elizabetht.service;

import java.util.ArrayList;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Tender;
import com.github.elizabetht.model.TenderQuotation;

public interface BuyerService {
	void save(Buyer buyer);
	Buyer login(Buyer buyer);
	void reqTender(Tender tender);
	ArrayList<TenderQuotation> getSellerResponse(int buyerId);
	ArrayList<Tender> getTenderList(int buyerId);
	void tenderAction(int tenderId, int value);
}
