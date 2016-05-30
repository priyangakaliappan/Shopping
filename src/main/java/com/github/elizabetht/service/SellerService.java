package com.github.elizabetht.service;

import java.util.ArrayList;
import java.util.List;

import com.github.elizabetht.model.Seller;
import com.github.elizabetht.model.Tender;

public interface SellerService {
	void addSeller(Seller seller);
	Seller login(Seller seller);
	List<Tender> getAll();
	ArrayList<Seller> getAllSellers();

}
