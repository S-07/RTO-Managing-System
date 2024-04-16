package com.rtofinalproject.registrations.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rtofinalproject.registrations.model.LicenseRegisterModel;


@Repository
public interface LicenseRepository extends JpaRepository<LicenseRegisterModel, Long> {
	
	
	LicenseRegisterModel findByAadharNumber( String aadharNumber);

	LicenseRegisterModel  findByLicenseNumber(String licenseNumber);

}
