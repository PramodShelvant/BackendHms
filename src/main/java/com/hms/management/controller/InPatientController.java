package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@RequestMapping(value = "patient/{patientId}", method = RequestMethod.GET, produces = "application/json")
    public List<InPatient> getByIdInPatient(@PathVariable String patientId){
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of inpatient", inPatientServiceImpl.getInPatient(id));
		return inPatientServiceImpl.getInPatient(patientId);
    }

	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<InPatient> getAll() throws RecordNotFoundException {
 		return inPatientServiceImpl.getAllInPatient();
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteInPatient(@PathVariable int id) {
		return inPatientServiceImpl.deleteInPatient(id);
		
	}
}
