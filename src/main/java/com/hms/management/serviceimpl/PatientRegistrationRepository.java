package com.hms.management.serviceimpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PatientRegistration;

public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, String>{

}
