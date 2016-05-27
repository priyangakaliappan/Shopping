package com.github.elizabetht.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.github.elizabetht.model.Tender;
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
	public String login(Model model,@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpSession session) {
		Buyer buyer = new Buyer();
		buyer.setEmail(username);
		buyer.setPassword(password);
		Buyer user = buyerService.login(buyer);
		session = request.getSession(true);
		session.setAttribute("user", user);
		if(user == null){
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
	
	@RequestMapping(value="/addTender", method=RequestMethod.GET)
	public String addTender(Model model) {
		
		return "buyer/addTender";
	}
	
	@RequestMapping(value="/addTender", method=RequestMethod.POST)
	public String saveTender(Model model,
			@RequestParam("referenceNo") String referenceNo,
			@RequestParam("productName") String productName,
			@RequestParam("description") String description,
			@RequestParam("quantity") int quantity,
			@RequestParam("closeTime") Date closeTime,HttpSession session){
		
		Buyer currentBuyer = (Buyer) session.getAttribute("user");
		int buyerId = currentBuyer.getBuyerId();
		Tender tender = new Tender();
		tender.setReferenceNo(referenceNo);
		tender.setBuyerFk(buyerId);
		tender.setCloseTime(closeTime);
		tender.setProductDescription(description);
		tender.setProductName(productName);
		tender.setQuantity(quantity);
		tender.setStartTime(new Date());
		tender.setIsActive((short)1);
		tender.setRowCreated(new Date());
		
		buyerService.reqTender(tender);
		model.addAttribute("message", "Saved tender detail");
		return "buyer/addTender";
	}
	
}
