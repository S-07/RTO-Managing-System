package com.rtofinalproject.registrations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {

	
	 @GetMapping("/user/home")
	    public String UserHomePage() {
	        return "User/userHome";
	    }
}
