package com.hms.management.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.OpdOutPatient;

public interface OpdOutPatientRepository extends JpaRepository<OpdOutPatient, Integer>{

	List<OpdOutPatient> findByPatientId(String patientId);
	List<OpdOutPatient> findByDoctorId(String doctorId);
	@Query("select o.appointmentDate as ad,u.name as name,u.mobileNo as mnumber,u.gender as gender,u.userId as userId from OpdOutPatient o inner join UserRegistration u on u.userId=o.patientId ")
	List<Map<String,Object>> fetchOpdPatient();

}
