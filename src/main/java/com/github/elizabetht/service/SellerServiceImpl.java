/**
 * 
 */
package com.github.elizabetht.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.mappers.SellerMapper;
import com.github.elizabetht.model.Seller;
import com.github.elizabetht.model.Tender;
import com.github.elizabetht.model.TenderQuotation;

/**
 * @author pragis
 *
 */
@Service("sellerService")
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerMapper sellerMapper;

	@Transactional
	public void addSeller(Seller seller) {
		sellerMapper.addSeller(seller);
		System.out.println("SUCCESSSSS");

	}
	public Seller login(Seller seller) {
		System.out.println("SELLER IMPL::::::::::::");
		Seller getSeller = sellerMapper.login(seller);
		return getSeller;
	}

	public List<Tender> getAll() {
		System.out.println("IMPL:::::::::::");
		List<Tender> getAllList = sellerMapper.tendersList();
		System.out.println("getAllList "+getAllList);
		return getAllList;
	}
	
	public ArrayList<Seller> getAllSellers() {
		ArrayList<Seller> list = sellerMapper.getAllSellers();
		return list;
	}

	public Tender getTender(int tenderId) {
		Tender getTender = sellerMapper.getTender(tenderId);
		System.out.println("GGG "+getTender);
		return getTender;
	}

	public void submitQuotation(TenderQuotation tenderQuotation) {
		sellerMapper.submitQuotation(tenderQuotation);
		
	}

}
