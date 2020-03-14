package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer>{

	UserRegistration findByEmail(String email);

	UserRegistration findByMobileNo(String mobileNo);

	UserRegistration findByUserId(String patientId);
	 List<UserRegistration> findByRole(String role);

 
}
