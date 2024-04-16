package com.rtofinalproject.registrations.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rtofinalproject.registrations.model.LicenseComplaintsModel;
import com.rtofinalproject.registrations.model.LicenseRegisterModel;
import com.rtofinalproject.registrations.model.VehicleDetailsModel;
import com.rtofinalproject.registrations.repositories.LicenseRepository;
import com.rtofinalproject.registrations.repositories.VehicleRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class AdminCRUDController {

	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	

	
	
	@GetMapping("/admin/DisplayRecords")
	public String ListLicenseHolders(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayLicense", licenseRepository.findAll());
		return "Admin/License/DisplayLicense";
	}
	
	 @GetMapping("/searchLicense")
		public String searchLicense(@RequestParam("licenseNumber") String licenseNumber,LicenseRegisterModel licenseRegisterModel, Model model) {
	    	licenseRegisterModel = licenseRepository.findByLicenseNumber(licenseNumber);
	    	if(licenseRegisterModel != null) {
			model.addAttribute("displayLicense", licenseRepository.findByLicenseNumber(licenseNumber));
			return "Admin/License/displayAfterSearched";
	    	}else {
				model.addAttribute("message","Please enter a valid license Number");
				
				return "ERRORS/ErrorSearchComplaints";
				}

		}
	
	@GetMapping("/holder/update")
	public String UpdateLicenseHolders(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayLicense", licenseRepository.findAll());
		return "Admin/License/UpdateLicense";
	}
	
	 @GetMapping("/holder/update1")
		public String searchAdmin(@RequestParam("licenseNumber") String licenseNumber,LicenseRegisterModel licenseRegisterModel, Model model) {
	    	licenseRegisterModel = licenseRepository.findByLicenseNumber(licenseNumber);
	    	if(licenseRegisterModel != null) {
			model.addAttribute("displayLicense", licenseRepository.findByLicenseNumber(licenseNumber));
			return "Admin/License/UpdateAfterSearch";
	    	}else {
				model.addAttribute("message","Please enter a valid license Number");
				
				return "ERRORS/ErrorSearchComplaints";
				}

		}
	    
	
	
	@PostMapping("/holder/update")
	public String UpdateLicenseHolder(LicenseRegisterModel licenseRegisterModel) {
		System.out.println("Sanjay");
		
		licenseRepository.save(licenseRegisterModel);
		return "Admin/License/UpdateAfterSearch";
	}
	
	
	@GetMapping("/LicenseUpdate/{id}")
	public String UpdateLicense(@PathVariable("id") Long id,Model model) {
		System.out.println("Sanjay Inside Update");
		LicenseRegisterModel licenseModel = licenseRepository.findById(id).get();
		model.addAttribute("updateLicense",licenseModel);
		return "Admin/License/UpdateLicenseDetails";	
	}
	
	@PostMapping("/license/update")
	public String SaveUpdatedLicense(LicenseRegisterModel licenseRegisterModel) {
		System.out.println(licenseRegisterModel);
		licenseRepository.save(licenseRegisterModel);
		
		return "redirect:/admin/DisplayRecords";
	}
	
	//---------------------------DELETE-------------------------------------
	
	@GetMapping("/holder/delete")
	public String DeleteLicenseHolders(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayLicense", licenseRepository.findAll());
		return "Admin/License/DeleteLicense";
	}
	
	@PostMapping("/holder/delete")
	public String DeleteLicenseHolder(LicenseRegisterModel licenseRegisterModel) {
		System.out.println("Sanjay");
		licenseRepository.save(licenseRegisterModel);
		return "redirect:/DeleteLicense";
	}
	
	 @GetMapping("/holder/delete1")
		public String searchDelete(@RequestParam("licenseNumber") String licenseNumber,LicenseRegisterModel licenseRegisterModel, Model model) {
	    	licenseRegisterModel = licenseRepository.findByLicenseNumber(licenseNumber);
	    	if(licenseRegisterModel != null) {
			model.addAttribute("displayLicense", licenseRepository.findByLicenseNumber(licenseNumber));
			return "Admin/License/DeleteAfterSearch";
	    	}else {
				model.addAttribute("message","Please enter a valid license Number");
				
				return "ERRORS/ErrorSearchComplaints";
				}

		}
	
	
	
	@GetMapping("/license/delete/{id}")
	public String DeleteLicense(@PathVariable("id") Long id) {
		licenseRepository.deleteById(id);
		return "redirect:/admin/DisplayRecords";	
	}
	
/*<!----------------------- ------------------------------>*/
	
	
	@GetMapping("/admin/vehicleDetails")
	public String DeleteVehicle(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayVehicle", vehicleRepository.findAll());
		return "Admin/Vehicles/DisplayVehicleDetails";
	}
	
	@GetMapping("/vehicle/search")
	public String searchVehicle(@RequestParam("aadharNumber") String aadharNumber,VehicleDetailsModel vehicleDetailsModel, Model model) {
    	vehicleDetailsModel = vehicleRepository.findByaadharNumber(aadharNumber);
    	if(vehicleDetailsModel != null) {
		model.addAttribute("displayVehicle", vehicleRepository.findByaadharNumber(aadharNumber));
		return "Admin/Vehicles/displayVehicleAfterSearch";
    	}else {
			model.addAttribute("message","Please enter a valid license Number");
			
			return "ERRORS/ErrorSearchComplaints";
			}

	}
	
	@PostMapping("/admin/vehicleDetails")
	public String Deletevechile(VehicleDetailsModel vehicleDetailsModel) {
		System.out.println("Sanjay");
		vehicleRepository.save(vehicleDetailsModel);
		return "redirect:/DeleteLicense";
	}
	
	@GetMapping("/delete/vehicle")
	public String DeleteVehicleDetails(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayVehicle", vehicleRepository.findAll());
		return "Admin/Vehicles/DeleteVehicleDetails";
	}
	
	@GetMapping("/vehicle/searchDelete")
	public String searchDeleteVehicle(@RequestParam("aadharNumber") String aadharNumber,VehicleDetailsModel vehicleDetailsModel, Model model) {
    	vehicleDetailsModel = vehicleRepository.findByaadharNumber(aadharNumber);
    	if(vehicleDetailsModel != null) {
		model.addAttribute("displayVehicle", vehicleRepository.findByaadharNumber(aadharNumber));
		return "Admin/Vehicles/DeleteVehicleAfterSearch";
    	}else {
			model.addAttribute("message","Please enter a valid license Number");
			
			return "ERRORS/ErrorSearchComplaints";
			}

	}
	
	
	
	  @GetMapping("/vehicle/delete/{id}") public String
	  DeleteParticularVehicle(@PathVariable("id") Long id) {
	 vehicleRepository.deleteById(id); return
	  "redirect:/admin/vehicleDetails"; }
	
	
	
}
