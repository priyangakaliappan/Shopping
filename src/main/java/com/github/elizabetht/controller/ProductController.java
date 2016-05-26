package com.github.elizabetht.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.elizabetht.model.Product;
import com.github.elizabetht.service.ProductService;
import com.github.elizabetht.service.StudentService;

@Controller
public class ProductController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProductService productService;

	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(Model model) {
		ArrayList<Product> productList = productService.getAllList();
		model.addAttribute("productList", productList);
		return "admin";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String insert(@RequestParam("productName")String productName,Model model, RedirectAttributes redirectAttributes) {
		Product product = new Product();
		product.setProductName(productName);
		product.setIsActive((short)1);
		product.setRowCreated(new Date());
		productService.insertProduct(product);
		redirectAttributes.addFlashAttribute("message", "Saved Product details");
		return "redirect:admin.html";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)
	public String insert() {
		return "addProduct";
	}
}
