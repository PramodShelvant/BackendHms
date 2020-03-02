package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByAptId(String id);

	List<Appointment> findByPatientId(String patientId);

	List<Appointment> findByDoctorId(String doctorId);

	List<Appointment> findByAppointmentStatus(String appointmentStatus);

 


	
}
