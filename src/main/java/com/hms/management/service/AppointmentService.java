package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Appointment;
 
public interface AppointmentService {
	
	public Appointment bookAppointment(Appointment appointment) throws RecordNotFoundException;
	public Appointment getAppointment(int id) throws RecordNotFoundException;
	public List<Appointment> getAllAppointment() throws RecordNotFoundException;
	public List<Map<String, Object>> getbookAppointment(String aptId) throws RecordNotFoundException;
    public List<Appointment> getPatientId(String patientId) throws RecordNotFoundException;
	List<Appointment> getByDoctorId(String doctorId) throws RecordNotFoundException;


 }