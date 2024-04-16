package com.rtofinalproject.registrations.services;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtofinalproject.registrations.model.LicenseRegisterModel;
import com.rtofinalproject.registrations.repositories.LicenseRepository;

@Service
public class LicenseDetailsService {
	
	@Autowired
	private LicenseRepository licenseRepository;

	public static String generateLicenseNumber(LicenseRegisterModel licenseDetails) {
        // Example: State-Age-Initials-RandomString
		System.out.println(licenseDetails);
        String randomString = licenseDetails.generateRandomString(6); // Generate a random alphanumeric string
        return licenseDetails.getState()  + licenseDetails.getAge() 
        + licenseDetails.getFullName().substring(0, 2).toUpperCase() +
                randomString;
    }
	
	 public String checkRenewal(String licenseNumber) {
	        LicenseRegisterModel licenseRegister = licenseRepository.findByLicenseNumber(licenseNumber);
	        long diffInMillies = Math.abs(new Date().getTime() - licenseRegister.getDateOfIssue().getTime());
	        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
	        if (diff < 20) {
	            return "No need of renewal";
	        } else  {
	            return "Fine: 10000";
	        }
	    }

	}
