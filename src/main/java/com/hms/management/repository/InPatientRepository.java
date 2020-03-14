package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.InPatient;

public interface InPatientRepository extends JpaRepository<InPatient, Integer>{

	public List<InPatient> findByPatientId(String patientId);

	
	//@Query(name = "SELECT InPatient.PatientId, UserRegistration.name, FROM InPatient INNER JOIN UserRegistration ON InPatient.patientId=UserRegistration.userId")
	//@Query(name = "SELECT t.PatientId, t1.name FROM UserRegistration t1, InPatient t2")
 

	public InPatient findByIpdId(String ipdId);
    public List<InPatient> findByDoctorIdAndDisChargeStatus(String doctorId, String disChargeStatus);
    public List<InPatient> findByDisChargeStatus(String disChargeStatus);


	//public List<InPatient> findByPatientIdAndStatus(String patientId, String status);


	public List<InPatient> findByPatientIdAndDisChargeStatus(String patientId, String disChargeStatus);
 

 
 
	

}
