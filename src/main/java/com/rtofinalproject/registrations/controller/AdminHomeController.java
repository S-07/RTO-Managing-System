package com.rtofinalproject.registrations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rtofinalproject.registrations.model.LicenseComplaintsModel;
import com.rtofinalproject.registrations.repositories.LicenseComplaintsRepository;

@Controller
public class AdminHomeController {
	
	@Autowired
	LicenseComplaintsRepository complaintsRepository;

	 @GetMapping("/admin/home")
	    public String AdminHomePage() {
	        return "Admin/adminHome";
	    }
		
	 @GetMapping("/admin/complaints")
	    public String GetComplaints(Model model) {
	    	System.out.println("Get Mapping");
	    	LicenseComplaintsModel licenseComplaintsModel = new LicenseComplaintsModel();
	    	model.addAttribute("complaintsModel", licenseComplaintsModel);
	        return "Admin/Complaints/LicenseComplaints";
	    }

	    
	    @PostMapping("/admin/complaints")
	    public String saveComplaints(LicenseComplaintsModel licenseComplaintsModel) {
	    	System.out.println(licenseComplaintsModel);
	    	complaintsRepository.save(licenseComplaintsModel);
	    	
	    	return "redirect:/admin/home";
	    }
	    
//	    @GetMapping("/searchComplaints")
//		public String searchAdmin(@RequestParam("licenseNumber") String licenseNumber,LicenseComplaintsModel licenseComplaintsModel, Model model) {
//	    	licenseComplaintsModel = complaintsRepository.findBylicenseNumber(licenseNumber);
//	    	if(licenseComplaintsModel != null) {
//			model.addAttribute("complaints", complaintsRepository.findByLicenseNumber(licenseNumber));
//			return "HOME/displayComplaints";
//	    	}else {
//				model.addAttribute("message","Please enter a valid license Number");
//				
//				return "ERRORS/ErrorSearchComplaints";
//				}
//
//		}
	    
	    @GetMapping("/searchComplaints")
	    public String searchAdmin(@RequestParam("licenseNumber") String licenseNumber, Model model) {
	        List<LicenseComplaintsModel> list = complaintsRepository.findByLicenseNumber(licenseNumber);

	        if(!list.isEmpty()) {
	            model.addAttribute("complaints", list);
	            return "HOME/displayComplaints";
	        } else {
	            model.addAttribute("message","Please enter a valid license Number");
	            return "ERRORS/ErrorSearchComplaints";
	        }
	    }
   


		 
}
