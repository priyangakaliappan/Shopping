package com.github.elizabetht.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.mappers.BuyerMapper;
import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Tender;
import com.github.elizabetht.model.TenderQuotation;

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
	
	public ArrayList<TenderQuotation> getSellerResponse(int buyerId) {
		// TODO Auto-generated method stub
		ArrayList<TenderQuotation> response = buyerMapper.getSellerResponse(buyerId);
		return response;
	}

	public ArrayList<Tender> getTenderList(int buyerId) {
		// TODO Auto-generated method stub
		ArrayList<Tender> tenderList = buyerMapper.getTenderList(buyerId);
		return tenderList;
	}
	
	@Transactional
	public void tenderAction(int tenderId, int value) {
		// TODO Auto-generated method stub
		if(value<=0){
			buyerMapper.suspendTender(tenderId);
		}else{
			buyerMapper.activateTender(tenderId);
		}
	}

}
