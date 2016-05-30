package com.github.elizabetht.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.elizabetht.mappers.BuyerMapper;
import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Seller;
import com.github.elizabetht.model.Tender;
import com.github.elizabetht.model.TenderQuotation;
import com.github.elizabetht.service.BuyerService;
import com.github.elizabetht.service.ProductService;
import com.github.elizabetht.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private BuyerMapper buyerMapper;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/sellerLogin", method=RequestMethod.GET)
	public String signIn(Model model) {
		model.addAttribute("sellerCredential", new Seller()); 
		return "sellerLogin";
	}	
	
	@RequestMapping(value="/sellerLogin", method=RequestMethod.POST)
	public String login(@ModelAttribute("sellerCredential")Seller sellerCredential, 
		      BindingResult result, Model model) {
		Seller seller = sellerService.login(sellerCredential);
		return "redirect:tenderList.html";
	}
	
	@RequestMapping(value="/sellerSignup", method=RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("sellers", new Seller()); 
		return "sellerSignUp";
	}
	
	@RequestMapping(value="/sellerSignup", method=RequestMethod.POST)
	public String addSeller(@ModelAttribute("seller")Seller seller, 
		      BindingResult result, Model model) {
		sellerService.addSeller(seller);
		model.addAttribute("sellerCredential", new Seller()); 
		return "sellerLogin";
	}
	
	@RequestMapping(value="/tenderList", method=RequestMethod.GET)
	public String viewTenders(Model model) {
		List<Tender> allTenders = sellerService.getAll();
		model.addAttribute("tendersList", allTenders);
		return "tendersList";
	}
	@RequestMapping(value="/quotation", method=RequestMethod.GET)
	public String quotation(Model model,@RequestParam("tenderId") String tenderId) {
		model.addAttribute("tenderQuotation", new TenderQuotation()); 
		Integer tenderIdd = Integer.parseInt(tenderId);
		Tender tender = sellerService.getTender(tenderIdd);
		model.addAttribute("tender", tender);
		return "tenderQuotation";
	}
	
	@RequestMapping(value="/submitQuotation", method=RequestMethod.POST)
	public String submitTenderQuotation(@ModelAttribute("tenderQuotation")TenderQuotation tenderQuotation, 
		      BindingResult result, Model model) {
		sellerService.submitQuotation(tenderQuotation);
		System.out.println("FINAL:::: ");
		Buyer getBuyer = buyerMapper.getBuyer(tenderQuotation.getBuyerFk());
		System.out.println(getBuyer.getEmail());
		
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(getBuyer.getEmail());
        email.setSubject("You have a tender quotation notification");
        email.setText("Quotation details");
        // sends the e-mail
        try{
        mailSender.send(email);
        }catch(Exception e){
        	System.out.println(e);
        }
        System.out.println("SUCCESS::::::**** ");
		return "";
	}

}
