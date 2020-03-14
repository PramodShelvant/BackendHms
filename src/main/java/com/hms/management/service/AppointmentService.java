package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Appointment;
 
public interface AppointmentService {
	
	public Object bookAppointment(Appointment appointment) throws RecordNotFoundException;
	public Appointment getAppointment(int id) throws RecordNotFoundException;
	public List<Appointment> getAllAppointment() throws RecordNotFoundException;
	public List<Map<String, Object>> getbookAppointment(String aptId) throws RecordNotFoundException;
    public List<Appointment> getPatientId(String patientId) throws RecordNotFoundException;
	public List<Appointment> getByDoctorId(String doctorId) throws RecordNotFoundException;
	public Object updateAppointmentByStatus(Appointment appointment);
	public Object update(Appointment app);
	public Object deleteAppointment(int id);
	public Object addNewAppointment(Appointment appointment);
	public List<Appointment> getByDate(String date);
	//public List<Appointment> findFirst10ByDate(String date);
	public Object getOneWeekAppointments(String date);
	public List<Appointment> getAll();



 }