package com.rtofinalproject.registrations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtofinalproject.registrations.model.AdminRegisterModel;


public interface AdminRepository extends JpaRepository<AdminRegisterModel, Long> {

	AdminRegisterModel findByAdminname(String adminname);

	

	

}
