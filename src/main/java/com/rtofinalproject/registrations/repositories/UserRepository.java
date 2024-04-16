package com.rtofinalproject.registrations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtofinalproject.registrations.model.UserRegisterModel;

public interface UserRepository extends JpaRepository<UserRegisterModel, Long>{

	UserRegisterModel findByUsername(String username);

	

}
