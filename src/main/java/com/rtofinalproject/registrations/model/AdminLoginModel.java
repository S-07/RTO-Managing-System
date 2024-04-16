package com.rtofinalproject.registrations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class AdminLoginModel {
	@Id
	@NotBlank(message="I should be entered")
	@Email(message="Email should be in correct format")
	private String username;
	@Column
	@NotBlank(message="Password should be entered")
	@Size(min = 8, message = "password must be at least 8 characters long")
	@Pattern(regexp = "^(?==.*[a-z]) (?=.*[A-Z]) (?=.*\\d).+$", message = "Password must contain atleast one upper and lower case")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
