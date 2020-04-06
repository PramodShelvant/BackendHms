package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer>{

	List<UserRegistration> findByEmail(String email);

	UserRegistration findByMobileNo(String mobileNo);

	UserRegistration findByUserId(String patientId);
	
	 List<UserRegistration> findByRole(String role);
	 @Query("delete from UserRegistration u where u.userId=?1")
	 void mydelete(String patientId);
	 
	 //List<Map<String,Object>> findUser(String role);

 
}
