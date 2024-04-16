package com.rtofinalproject.registrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rtofinalproject.registrations.model.LicenseRegisterModel;
import com.rtofinalproject.registrations.repositories.LicenseRepository;
import com.rtofinalproject.registrations.services.LicenseDetailsService;

@Controller
public class LicenseRenewalController {

	@Autowired
	private LicenseDetailsService licenseDetailsService;
	
	@Autowired
	private LicenseRepository licenseRepo;
	
//	@Autowired
//	private LicenseRegisterModel licenseRegisterModel;
	
	/*
	 * @GetMapping("/checkRenewal") public String CheckRenewalHome() { return
	 * "CheckRenewal"; }
	 */
	 
	 
	@GetMapping("/checkRenewal")
    public String showForm(Model model) {
        LicenseRegisterModel licenseRegisterModel = new LicenseRegisterModel();
        model.addAttribute("licenseRegister", licenseRegisterModel);
        return "HOME/checkRenewal";
    }
	
	@PostMapping("/checkRenewal")
    public String submitForm(@RequestParam("licenseNumber") String licenseNumber, @ModelAttribute("licenseRegister") LicenseRegisterModel licenseRegisterModel, Model model) {
        
		licenseRegisterModel = licenseRepo.findByLicenseNumber(licenseNumber);
		if(licenseRegisterModel != null) {
		String renewalStatus = licenseDetailsService.checkRenewal(licenseRegisterModel.getLicenseNumber());
        
        model.addAttribute("renewalStatus", renewalStatus);
        return "HOME/checkRenewal";
		}
		else {
			model.addAttribute("message","Please enter a valid license Number");
		
		return "ERRORS/ErrorLicenseRenewal";
		}
    }
	
	
}
