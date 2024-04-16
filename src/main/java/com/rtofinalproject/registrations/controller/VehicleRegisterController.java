package com.rtofinalproject.registrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rtofinalproject.registrations.model.VehicleDetailsModel;
import com.rtofinalproject.registrations.repositories.VehicleRepository;

@Controller
public class VehicleRegisterController {

	
	@Autowired
	private VehicleRepository vehicleRepo;


    @GetMapping("/admin/vehicle")
    public String VehicleRegistrationPage(Model model) {
    	System.out.println("Get Mapping");
    	VehicleDetailsModel vehicleModel = new VehicleDetailsModel();
    	model.addAttribute("vehicleModel", vehicleModel);
        return "Admin/Vehicles/RegisterVehicle";
    }

    
    @PostMapping("/admin/VehicleRegister")
    public String saveLicenses(VehicleDetailsModel vehicleDetailsModel) {
    	System.out.println(vehicleDetailsModel);
    	vehicleRepo.save(vehicleDetailsModel);
    	return "redirect:/admin/home";
    }

}




