package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Appointment;

public interface MyAppointmentRepo extends JpaRepository<Appointment, Integer>{
List<Appointment> findByPatientId(String patientId);
}
