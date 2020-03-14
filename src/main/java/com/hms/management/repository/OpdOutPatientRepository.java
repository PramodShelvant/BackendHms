package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.OpdOutPatient;

public interface OpdOutPatientRepository extends JpaRepository<OpdOutPatient, Integer>{

	List<OpdOutPatient> findByPatientId(String patientId);
	List<OpdOutPatient> findByDoctorId(String doctorId);
	@Query("select o.appointmentDate,u.name,u.mobileNo,u.gender,u.userId from OpdOutPatient o left join UserRegistration u on u.userId=o.patientId ")
	List<Object[]> fetchOpdPatient();

}
