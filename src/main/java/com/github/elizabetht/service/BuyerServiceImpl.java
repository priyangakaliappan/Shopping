package com.github.elizabetht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.mappers.BuyerMapper;
import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Product;
import com.github.elizabetht.model.Tender;

@Service("buyerService")
public class BuyerServiceImpl implements BuyerService{

	@Autowired
	private BuyerMapper buyerMapper;

	@Transactional
	public void save(Buyer buyer) {
		// TODO Auto-generated method stub
		buyerMapper.insert(buyer);
	}

	public Buyer login(Buyer buyer) {
		// TODO Auto-generated method stub
		Buyer validate = buyerMapper.login(buyer);
		return validate;
		
	}
	
	@Transactional
	public void reqTender(Tender tender) {
		// TODO Auto-generated method stub
		
		buyerMapper.addTender(tender);
	}
	
	
}
