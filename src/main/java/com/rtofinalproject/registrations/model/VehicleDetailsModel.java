package com.rtofinalproject.registrations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NewVehicles")
public class VehicleDetailsModel {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long vehicleId;
	
	@Column(name = "Aadhar Number")
	private String aadharNumber;
	
	@Column(name = "Owner Name")
	private String ownerName;
	
	@Column(name = "Owner Contact")
	private String ownerContact;
	
	@Column(name = "Owner address")
	private String owneraddress;
	
	@Column(name = "Vehicle Category")
	private String vehicleCategory;
	
	@Column(name = "Maker's Class")
	private String makersClass;
	
	@Column(name = "Manufactured Date")
	private String manufacturedDate;
	
	@Column(name = "Fuel Type")
	private String fuelUsed;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}

	public String getOwneraddress() {
		return owneraddress;
	}

	public void setOwneraddress(String owneraddress) {
		this.owneraddress = owneraddress;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public String getMakersClass() {
		return makersClass;
	}

	public void setMakersClass(String makersClass) {
		this.makersClass = makersClass;
	}

	public String getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public String getFuelUsed() {
		return fuelUsed;
	}

	public void setFuelUsed(String fuelUsed) {
		this.fuelUsed = fuelUsed;
	}

	@Override
	public String toString() {
		return "VehicleDetailsModel [vehicleId=" + vehicleId + ", aadharNumber=" + aadharNumber + ", ownerName="
				+ ownerName + ", ownerContact=" + ownerContact + ", owneraddress=" + owneraddress + ", vehicleCategory="
				+ vehicleCategory + ", makersClass=" + makersClass + ", manufacturedDate=" + manufacturedDate
				+ ", fuelUsed=" + fuelUsed + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
