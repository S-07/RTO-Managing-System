package com.rtofinalproject.registrations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NewAdmins")
public class AdminRegisterModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long admin_id;

	@Column(name = "adminname")
	private String adminname;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "mobilenumber")
	private String mobilenumber;
	
	@Column(name = "Address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "Countries")
	private String countries;
	
	
	@Column (name = "Gender")
	private String gender;

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "AdminRegisterModel [admin_id=" + admin_id + ", adminname=" + adminname + ", fullname=" + fullname
				+ ", mobilenumber=" + mobilenumber + ", address=" + address + ", email=" + email + ", password="
				+ password + ", countries=" + countries +  ", gender=" + gender + "]";
	}
	
	
	
	
	
	
	
}
