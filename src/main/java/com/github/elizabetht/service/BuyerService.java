package com.github.elizabetht.service;

import com.github.elizabetht.model.Buyer;

public interface BuyerService {

	void save(Buyer buyer);

	Buyer login(Buyer buyer);
}
