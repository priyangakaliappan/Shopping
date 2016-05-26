package com.github.elizabetht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.elizabetht.model.Product;
import com.github.elizabetht.model.Student;
import com.github.elizabetht.model.StudentLogin;
import com.github.elizabetht.service.StudentService;

@Controller
@SessionAttributes("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String signup(Model model) {
		Student student = new Student();
		//model.addAttribute("student", student);
		return "admin";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("student") Student student, Model model) {
		if(studentService.getStudentByUserName(student.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			studentService.insertStudent(student);
			model.addAttribute("message", "Saved student details");
			return "redirect:login.html";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		StudentLogin studentLogin = new StudentLogin();
		model.addAttribute("studentLogin", studentLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("studentLogin") StudentLogin studentLogin) {
		boolean found = studentService.getStudentByLogin(studentLogin.getUserName(), studentLogin.getPassword());
		if (found) {				
			return "success";
		} else {				
			return "failure";
		}
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String products(Model model) {
		System.out.println("STUDENT CONTROLLER:::::::::::");
		List<Product> x = studentService.allProducts();
		for(int i=0;i<x.size();i++){
			
		}
		
		
		System.out.println("FINAL:::: "+x);
		model.addAttribute("productList",x);
		return "products";
	}
}
