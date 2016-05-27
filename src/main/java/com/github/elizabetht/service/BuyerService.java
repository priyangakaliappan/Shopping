package com.github.elizabetht.service;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Tender;

public interface BuyerService {

	void save(Buyer buyer);

	Buyer login(Buyer buyer);

	void reqTender(Tender tender);
}
