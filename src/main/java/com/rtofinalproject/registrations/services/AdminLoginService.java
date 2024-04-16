package com.rtofinalproject.registrations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtofinalproject.registrations.model.AdminRegisterModel;
import com.rtofinalproject.registrations.repositories.AdminRepository;

@Service
public class AdminLoginService {

	
	@Autowired
	private AdminRepository adminRepository;
	
	public boolean adminLogin(AdminRegisterModel adminRegisterModel) {
		AdminRegisterModel adminReg = adminRepository.findByAdminname(adminRegisterModel.getAdminname());
		if(adminReg != null && adminReg.getPassword().equals(adminRegisterModel.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
}
