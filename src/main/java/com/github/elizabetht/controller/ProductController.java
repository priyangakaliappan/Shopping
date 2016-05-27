package com.github.elizabetht.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




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
public class ProductController extends HttpServlet{
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProductService productService;

	@Autowired
	ServletContext servletContext;
	
	private ArrayList<Product> added = new ArrayList<Product>();
	
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
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String products(Model model) {
		List<Product> productsList = productService.allProducts();
		System.out.println("FINAL:::: "+productsList);
		model.addAttribute("productList",productsList);
		return "products";
	}
	@RequestMapping(value="/addToCart", method=RequestMethod.GET)
	public String addToCart(Model model,@RequestParam("id")String productId,HttpServletRequest request,HttpSession session) {
		System.out.println("ADD TO  CART::::::: "+productId);
		Integer intt = Integer.parseInt(productId);
		Product product = productService.getProductById(intt);
		added.add(product);
		 session=request.getSession(true); 
		session.setAttribute("list",added);  
		System.out.println("FINAL::::::: "+product);
		return "addCart";
	}
}
