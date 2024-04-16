package com.rtofinalproject.registrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.rtofinalproject.registrations.model.AdminRegisterModel;
import com.rtofinalproject.registrations.services.AdminLoginService;


import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

	
	@Autowired
	private AdminLoginService adminLoginService;
	
	@GetMapping("/adminLog")
	public String AdminLogin(@Valid Model model) {
		System.out.println("inside admin login");
		model.addAttribute("admin", new AdminRegisterModel());
		return "Admin/Login/adminLogin";
	}
	
	
	@PostMapping("/adminLog")
	public String adminLoginSubmit(@Valid @ModelAttribute AdminRegisterModel adminRegisterModel, BindingResult bindingResult) {
		System.out.println("Inside Post Login for Admin");
		boolean success = adminLoginService.adminLogin(adminRegisterModel);
		System.out.println(success);
		String result="";
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			result="Admin/Login/adminLogin";
		}else if(success) {
			result="redirect:/admin/home";
		}else {
			result = "redirect:/adminLog";

		}
		return result;
	}
	
}
