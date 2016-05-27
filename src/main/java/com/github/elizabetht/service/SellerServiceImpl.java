/**
 * 
 */
package com.github.elizabetht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.mappers.SellerMapper;
import com.github.elizabetht.model.Seller;
import com.github.elizabetht.model.Tender;

/**
 * @author pragis
 *
 */
@Service("sellerService")
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerMapper sellerMapper;

	/* (non-Javadoc)
	 * @see com.github.elizabetht.service.SellerService#addSeller(com.github.elizabetht.model.Seller)
	 */
	@Transactional
	public void addSeller(Seller seller) {
		sellerMapper.addSeller(seller);
		System.out.println("SUCCESSSSS");
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.github.elizabetht.service.SellerService#login(com.github.elizabetht.model.Seller)
	 */
	public Seller login(Seller seller) {
		System.out.println("SELLER IMPL::::::::::::");
		Seller getSeller = sellerMapper.login(seller);
		return getSeller;
	}

	public List<Tender> getAll() {
		// TODO Auto-generated method stub
		System.out.println("IMPL:::::::::::");
		List<Tender> getAllList = sellerMapper.tendersList();
		System.out.println("getAllList "+getAllList);
		return getAllList;
	}

}
