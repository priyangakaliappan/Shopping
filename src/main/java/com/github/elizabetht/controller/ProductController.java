package com.github.elizabetht.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(Model model) {
		ArrayList<Product> productList = productService.getAllList();
		model.addAttribute("productList", productList);
		return "admin";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String insert(@RequestParam("productName") String productName,@RequestParam("imageFile") MultipartFile imageFile,Model model, RedirectAttributes redirectAttributes) {
		  String name = imageFile.getOriginalFilename();
		if (!imageFile.isEmpty()) {
            try {
                byte[] bytes = imageFile.getBytes();
                File dir = new File(servletContext.getRealPath("/webapp/product/"));
                if (!dir.exists())
                    dir.mkdirs();
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
            	System.out.println(e);
            }
        } else {
        	//do nothing
        }
		
		Product product = new Product();
		product.setProductName(productName);
		product.setImage(name);
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
