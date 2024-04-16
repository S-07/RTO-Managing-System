package com.rtofinalproject.registrations.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rtofinalproject.registrations.model.AdminRegisterModel;
import com.rtofinalproject.registrations.model.UserRegisterModel;
import com.rtofinalproject.registrations.repositories.AdminRepository;
import com.rtofinalproject.registrations.repositories.UserRepository;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class HomeController {
	private static final Logger LOGGER = Logger.getLogger(HomeController.class.getName());

	@Autowired
private UserRepository userRepo;
	@Autowired
	private AdminRepository adminRepo;

    @GetMapping("/")
    public String homePage() {
    	LOGGER.info("Displaying Main Page");
        return "HOME/home";
    }
    
    @GetMapping("/displayComplaints")
    public String Complaints() {
    	LOGGER.info("Displaying License Complaints");
        return "HOME/displayComplaints";
    }

    @GetMapping("/adminRegister")
    public String adminRegistrationPage(Model model) {
    	
    	AdminRegisterModel adminModel = new AdminRegisterModel();
    	model.addAttribute("adminModel", adminModel);
        return "Admin/Login/adminRegister";
    }
    
    @PostMapping("/adminRegister")
    public String saveAdmins(AdminRegisterModel adminRegisterModel) {
    	LOGGER.info("Registering New Admin");
    	System.out.println(adminRegisterModel);
    	adminRepo.save(adminRegisterModel);
    	return "redirect:/adminLog";
    }

    @GetMapping("/adminLogin")
    public String adminLoginPage() {
    	LOGGER.info("Admin Login");
        return "Admin/Login/adminLogin";
    }

    @GetMapping("/userRegister")
    public String userRegistrationPage(Model model) {
    	LOGGER.info("Registering New User");
       UserRegisterModel userModel = new UserRegisterModel();
        model.addAttribute("userModel", userModel);
        return "User/Login/userRegister";
    }

    @PostMapping("/userLogin")
    public String saveUsers(UserRegisterModel userModel, Model model) {
    	LOGGER.info("User Login");
        UserRegisterModel existingUser = userRepo.findByUsername(userModel.getUsername());
        if (existingUser != null) {
         
            model.addAttribute("error", "Username is already taken. Please enter a new username.");
            return "ERRORS/ErrorSearchComplaints";
        } else {
            
            System.out.println(userModel);
            userRepo.save(userModel);
            return "redirect:/userLog";
        }
    }


	
}








