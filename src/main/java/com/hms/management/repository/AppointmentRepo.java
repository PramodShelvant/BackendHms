 package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByAptId(String id);

	List<Appointment> findByPatientId(String patientId);

	List<Appointment> findByDoctorId(String doctorId);

	List<Appointment> findByAppointmentStatus(String appointmentStatus);
  // @Query("SELECT * FROM  appointment WHERE date BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW()")
	
	List<Appointment> findByDate(String date);
	//List<Appointment> findTop3ByOrderByDateAsc(String date);
    @Query("Select s from Appointment s")
    List<Appointment>  getAll();
 


	
}
