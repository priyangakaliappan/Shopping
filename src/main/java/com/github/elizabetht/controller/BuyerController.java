package com.github.elizabetht.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.service.BuyerService;

@Controller
public class BuyerController {
	
	
	@Autowired
	BuyerService buyerService;
	
	@RequestMapping(value="/buyer", method=RequestMethod.GET)
	public String buyer(Model model) {
		return "buyer/buyerLogin";
	}
	
	@RequestMapping(value="/tender", method=RequestMethod.POST)	
	public String login(Model model,@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
		Buyer buyer = new Buyer();
		buyer.setEmail(username);
		buyer.setPassword(password);
		Buyer validate = buyerService.login(buyer);
		if(validate == null){
			redirectAttributes.addFlashAttribute("message", "Invalid username/ password");
			return "redirect:buyer.html";
		}else{
			return "buyer/tender";
		}
		
	}
	
	@RequestMapping(value="/buyerSignup", method=RequestMethod.GET)
	public String regiterBuyer(Model model) {
		return "buyer/signup";
	}
	
	@RequestMapping(value="/buyerSignup", method=RequestMethod.POST)
	public String save(Model model, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email,
			@RequestParam("address") String address,
			@RequestParam("password") String password) {
		
		Buyer buyer = new Buyer();
		buyer.setFirstname(firstname);
		buyer.setLastname(lastname);
		buyer.setPhoneNumber(phone);
		buyer.setEmail(email);
		buyer.setAddress(address);
		buyer.setPassword(password);
		buyer.setIsActive((short)1);
		buyer.setRowCreated(new Date());
		buyerService.save(buyer);
		
		model.addAttribute("message", "Saved buyer details");
		
		return "buyer/signup";
	}
	
	
	
}
