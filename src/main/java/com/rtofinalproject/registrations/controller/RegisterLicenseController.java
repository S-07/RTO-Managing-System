package com.rtofinalproject.registrations.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rtofinalproject.registrations.model.LicenseRegisterModel;
import com.rtofinalproject.registrations.repositories.LicenseRepository;
import com.rtofinalproject.registrations.services.LicenseDetailsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterLicenseController {
	
	@Autowired
	private LicenseRepository licenseRepo;


    @GetMapping("/user/RegisterLicense")
    public String LicenseRegistrationPage(Model model) {
    	System.out.println("insiddfyghj");
    	LicenseRegisterModel licenseModel = new LicenseRegisterModel();
    	model.addAttribute("licenseModel", licenseModel);
        return "User/License/RegisterLicense";
    }
    @GetMapping("/user/showDetails")
    public String LicenseDetailsPage(Model model , HttpSession session) {
    	System.out.println("iyfgdhfh");
    	String ad =  (String) session.getAttribute("aadharNumber");
    	LicenseRegisterModel lc  = licenseRepo.findByAadharNumber(ad);
    	model.addAttribute("license",lc);
    	System.out.println(lc);
        return "User/License/LicenseDetails";
    }
    @PostMapping("/user/Register")
    public String saveLicenses(LicenseRegisterModel licenseRegisterModel,HttpServletRequest request) {
    	System.out.println(licenseRegisterModel);
        String licenseNumber = LicenseDetailsService.generateLicenseNumber(licenseRegisterModel);

        // Save license details (including license number) to the database
       
        licenseRegisterModel.setLicenseNumber(licenseNumber);
        
        licenseRepo.save(licenseRegisterModel); // Assuming you have a save method in your repository


    	HttpSession session = request.getSession();
    	session.setAttribute("aadharNumber",licenseRegisterModel.getAadharNumber() );
    	licenseRepo.save(licenseRegisterModel);
    	return "redirect:/user/home";
    }

}
