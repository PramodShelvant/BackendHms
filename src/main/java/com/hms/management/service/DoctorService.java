package com.hms.management.service;

import java.util.List;
import java.util.Optional;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Doctor;

public interface DoctorService {

	
	
	
	public Doctor addDoctor(Doctor doctor);
	public Optional<Doctor> getDoctor(int id) throws RecordNotFoundException;
    public List<Doctor> getAllDoctor() throws RecordNotFoundException;
    public String  deleteDoctor(int id);
}
