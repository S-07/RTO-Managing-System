package com.rtofinalproject.registrations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtofinalproject.registrations.model.VehicleDetailsModel;

public interface VehicleRepository extends JpaRepository<VehicleDetailsModel, Long> {

	

	void save(VehicleRepository vehicleRepository);

	VehicleDetailsModel findByaadharNumber(String aadharNumber);

}
