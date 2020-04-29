package com.hms.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Doctor;
import com.hms.management.repository.DoctorRepository;
import com.hms.management.service.DoctorService;


@Service
public class DoctorServiceImpl implements DoctorService{

	
	
	@Autowired
	public DoctorRepository doctorRepository;
	
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
 		return doctorRepository.save(doctor);
	}

	@Override
	public Optional<Doctor> getDoctor(int id) throws RecordNotFoundException {
 		return doctorRepository.findById(id);
	}

	@Override
	public List<Doctor> getAllDoctor() throws RecordNotFoundException {
 		return doctorRepository.findAll();
	}

	@Override
	public String deleteDoctor(int id) {
 	doctorRepository.deleteById(id);
	return "doctor details deleted succesful";
	}

}

	
	
	 