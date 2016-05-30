package com.github.elizabetht.controller;


import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Ternary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.elizabetht.model.Buyer;
import com.github.elizabetht.model.Seller;
import com.github.elizabetht.model.Tender;
import com.github.elizabetht.service.BuyerService;
import com.github.elizabetht.service.SellerService;

@Controller
public class BuyerController {
	
	
	@Autowired
	BuyerService buyerService;
	
	@Autowired
	SellerService sellerService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@RequestMapping(value="/buyer", method=RequestMethod.GET)
	public String buyer(Model model) {
		return "buyer/buyerLogin";
	}
	
	@RequestMapping(value="/tender", method=RequestMethod.GET)
	public String Canceltender(Model model) {
		return "buyer/tender";
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
		model.addAttribute("buyerDetails", new Buyer());
		return "buyer/signup";
	}
	
	@RequestMapping(value="/buyerSignup", method=RequestMethod.POST)
	public String save(Model model,@ModelAttribute("buyerDetails") Buyer buyer) {
		
		buyer.setIsActive((short)1);
		buyer.setRowCreated(new Date());
		buyerService.save(buyer);
		
		model.addAttribute("message", "Saved buyer details");
		
		return "buyer/signup";
	}
	
	@RequestMapping(value="/addTender", method=RequestMethod.GET)
	public String addTender(Model model) {
		model.addAttribute("tender",new Tender());
		return "buyer/addTender";
	}
	
	@RequestMapping(value="/addTender", method=RequestMethod.POST)
	public String saveTender(Model model,@ModelAttribute("tender")Tender tender,@RequestParam("closeTime") Date closeTime,HttpSession session){
		
		Buyer currentBuyer = (Buyer) session.getAttribute("user");
		int buyerId = currentBuyer.getBuyerId();
		tender.setBuyerFk(buyerId);
		tender.setCloseTime(closeTime);
		tender.setStartTime(new Date());
		tender.setIsActive((short)1);
		tender.setRowCreated(new Date());
		
		buyerService.reqTender(tender);
		String emails = "";
		ArrayList<Seller> list =sellerService.getAllSellers();
		for(int i=0;i<list.size();i++){
			emails =list.get(i).getEmail()+","+ emails;
			System.out.println(list.get(i).getEmail());
		}
		String splitmails = emails.substring(0, emails.length()-1);
		String[] sellermails = splitmails.split(",");
		
			SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(sellermails);
	        email.setSubject("You have a tender notification");
	        email.setText("Tender details");
	        // sends the e-mail
	        try{
	        mailSender.send(email);
	        }catch(Exception e){
	        	System.out.println(e);
	        }
		model.addAttribute("message", "Saved tender detail");
		return "buyer/addTender";
	}
	
}
