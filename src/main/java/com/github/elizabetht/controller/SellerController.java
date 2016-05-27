package com.github.elizabetht.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.elizabetht.model.Seller;
import com.github.elizabetht.service.ProductService;

@Controller
public class SellerController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/sellerLogin", method=RequestMethod.GET)
	public String signIn(Model model) {
		model.addAttribute("sellerCredential", new Seller()); 
		return "sellerLogin";
	}
	
	
	
	@RequestMapping(value="/sellerLogin", method=RequestMethod.POST)
	public String login(@ModelAttribute("sellerCredential")Seller sellerCredential, 
		      BindingResult result, Model model) {
		Seller seller = productService.login(sellerCredential);
        return "sellerLogin";
	}
	
	@RequestMapping(value="/sellerSignup", method=RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("sellers", new Seller()); 
		return "sellerSignUp";
	}
	
	@RequestMapping(value="/sellerSignup", method=RequestMethod.POST)
	public String addSeller(@ModelAttribute("seller")Seller seller, 
		      BindingResult result, Model model) {
		productService.addSeller(seller);
		model.addAttribute("sellers", new Seller()); 
		return "sellerLogin";
	}
	

}
