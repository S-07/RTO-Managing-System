package com.rtofinalproject.registrations.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtofinalproject.registrations.model.LicenseComplaintsModel;
import com.rtofinalproject.registrations.model.LicenseRegisterModel;



public interface LicenseComplaintsRepository extends JpaRepository<LicenseComplaintsModel, Long> {
	List<LicenseComplaintsModel> findByLicenseNumber(String licenseNumber);
	
	LicenseComplaintsModel  findBylicenseNumber(String licenseNumber);

}
