package com.github.elizabetht.service;

import com.github.elizabetht.model.Seller;

public interface SellerService {
	void addSeller(Seller seller);
	Seller login(Seller seller);

}
