package com.hms.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Doctor;
import com.hms.management.serviceimpl.DoctorServiceImpl;
@CrossOrigin() 
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	
	
	
	  @Autowired 
	  public DoctorServiceImpl doctorServiceImpl;
	  
	   
	  @CrossOrigin
		@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	    public Doctor addDoctor(@RequestBody Doctor doctor) {
			return doctorServiceImpl.addDoctor(doctor);
			
	         }
		@CrossOrigin
		@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	    public Optional<Doctor> getByIdDoctor(@PathVariable int id) throws RecordNotFoundException {
			return doctorServiceImpl.getDoctor(id);
		 
	    }
		@CrossOrigin
		@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
	    public List<Doctor> getAll() throws RecordNotFoundException {
			return doctorServiceImpl.getAllDoctor();
			 
	    }
		@CrossOrigin
		@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
        public String deleteDoctor(@PathVariable int id) {
			return doctorServiceImpl.deleteDoctor(id);
		
		}
}
