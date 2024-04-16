package com.rtofinalproject.registrations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Complaints")
public class LicenseComplaintsModel {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long complaints_id;
	
	@Column(name = "LicenseNumber")
	private String licenseNumber;

	@Column(name = "complaints")
	private String complaints;
	
	@Column(name = "Fine")
	private String fine;

	public Long getComplaints_id() {
		return complaints_id;
	}

	public void setComplaints_id(Long complaints_id) {
		this.complaints_id = complaints_id;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "LicenseComplaintsModel [complaints_id=" + complaints_id + ", licenseNumber=" + licenseNumber
				+ ", complaints=" + complaints + ", fine=" + fine + "]";
	}
	
	
}
