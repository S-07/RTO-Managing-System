package com.rtofinalproject.registrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rtofinalproject.registrations.model.UserLoginModel;
import com.rtofinalproject.registrations.model.UserRegisterModel;
import com.rtofinalproject.registrations.services.UserLoginService;


import jakarta.validation.Valid;




@Controller
public class UserController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@GetMapping("/userLog")
	public String UserLogin(@Valid Model model) {
		System.out.println("inside login");
		model.addAttribute("user", new UserLoginModel());
		return "User/Login/userLogin";
	}
	
	@PostMapping("/userLog")
	public String loginSubmit(@Valid @ModelAttribute("user") UserRegisterModel userRegisterModel, BindingResult bindingResult) {
		System.out.println("inside Post login");
		boolean success = userLoginService.userLogin(userRegisterModel);
		System.out.println(bindingResult);
		String res = "";
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			res = "User/Login/userLogin";
		}else if(success){
			res = "redirect:/user/home";
		}else {
			res = "redirect:/userLog";
		}
		return res;
	}
}
