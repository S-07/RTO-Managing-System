package com.rtofinalproject.registrations.model;

import java.sql.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LicenseRegisterModel {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "License ID")
	private Long license_id;
	
	@Column(name ="Full Name")
	private String fullName;
	
	@Column(name ="Age")
	private String age;
	
	@Column(name="Blood group")
	private String bloodGroup;
	
	@Column(name = "Aadhar Number")
	private String aadharNumber;
	
	@Column(name ="Mobile Number")
	private String mobileNumber;
	
	@Column(name ="State")
	private String state;
	
	@Column(name ="Address")
	private String address;
	
	@Column(name ="Date Of Issue")
	private Date dateOfIssue;
	
	@Column(name="Type Of vehicle")
	private String typeOfVehicle;
	
	@Column(name = "License Number")
	private String licenseNumber;

	

	public Long getLicense_id() {
		return license_id;
	}

	public void setLicense_id(Long license_id) {
		this.license_id = license_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getTypeOfVehicle() {
		return typeOfVehicle;
	}

	public void setTypeOfVehicle(String typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	
	

	

	

	@Override
	public String toString() {
		return "LicenseRegisterModel [license_id=" + license_id + ", fullName=" + fullName + ", age=" + age
				+ ", bloodGroup=" + bloodGroup + ", aadharNumber=" + aadharNumber + ", mobileNumber=" + mobileNumber
				+ ", state=" + state + ", address=" + address + ", dateOfIssue=" + dateOfIssue + ", typeOfVehicle="
				+ typeOfVehicle + ", licenseNumber=" + licenseNumber + "]";
	}

	public void generateLicenseNumber() {
        // Example: State-Age-Initials-RandomString
        String initials = fullName.substring(0, 2).toUpperCase();
        String randomString = generateRandomString(6);
        
        licenseNumber = state  + age  + initials  + randomString;
    }

	public String generateRandomString(int length) {
        String characters = "ABSXYZ012345678912345678";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomString.toString();
    }

	
	
}
