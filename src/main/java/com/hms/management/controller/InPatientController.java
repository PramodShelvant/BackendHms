package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.InPatient;
import com.hms.management.serviceimpl.InPatientServiceImpl;

@CrossOrigin()
@RestController
@RequestMapping("/inpatient")
public class InPatientController {

	@Autowired
	public InPatientServiceImpl inPatientServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public InPatient addInPatient(@RequestBody InPatient inPatient) throws RecordNotFoundException {
  	        return inPatientServiceImpl.addInPatient(inPatient);
	        
	    }
	@CrossOrigin
	@GetMapping(value = "/{patientId}/{status}")
    public Object getByIdInPatient(@PathVariable String patientId,@PathVariable String status){
 		return inPatientServiceImpl.getInPatient(patientId,status);
    }
    
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public Object getAll() throws RecordNotFoundException {
 		return inPatientServiceImpl.getAll();
    }
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteInPatient(@PathVariable int id) {
		return inPatientServiceImpl.deleteInPatient(id);
		
	}
	@CrossOrigin
	@RequestMapping(value = "doctor/{doctorId}/{disChargeStatus}", method = RequestMethod.GET, produces = "application/json")
    public Object getByDoctorId(@PathVariable String doctorId, @PathVariable String disChargeStatus){
		System.out.println("doctorId");
		System.out.println("disChargeStatus");
  		return inPatientServiceImpl.getByDoctorId(doctorId,disChargeStatus);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
    public InPatient updateIpd(@RequestBody InPatient inPatient) {
  	        return inPatientServiceImpl.updateIpdDisCharge(inPatient);
	        
	    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/{disChargeStatus}",method = RequestMethod.GET,produces = "application/json")
	public Object getByDisChargeStatus(@PathVariable String disChargeStatus) {
		return inPatientServiceImpl.getByDisChargeStatus(disChargeStatus);
		
	}
}
