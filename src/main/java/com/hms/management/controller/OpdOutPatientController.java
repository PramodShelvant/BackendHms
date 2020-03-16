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
import com.hms.management.model.OpdOutPatient;
import com.hms.management.serviceimpl.OpdOutPatientServiceImpl;
@CrossOrigin()
@RestController
@RequestMapping("/opdoutpatient")
public class OpdOutPatientController {

	
	@Autowired
	public OpdOutPatientServiceImpl opdOutPatientServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
      public OpdOutPatient addOutPatient(@RequestBody OpdOutPatient opdOutPatient) throws RecordNotFoundException {
			//Map<String,Object> map=new HashMap<String, Object>();
			//OpdOutPatient updated = opdOutPatientServiceImpl.addOutPatient(opdOutPatient);
	        //map.put("data saved", new ResponseEntity<OpdOutPatient>(updated, new HttpHeaders(), HttpStatus.OK));
	        return opdOutPatientServiceImpl.addOutPatient(opdOutPatient);
	        
	    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public OpdOutPatient getEmployeeById(@PathVariable int id) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of inpatient", opdOutPatientServiceImpl.getOutPatient(id));
		return opdOutPatientServiceImpl.getOpdOutPatientById(id);
    }
	@CrossOrigin
	@RequestMapping(value = "patient1/{id}", method = RequestMethod.GET, produces = "application/json")
    public Object getEmployeeById() throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of inpatient", opdOutPatientServiceImpl.getOutPatient(id));
		return opdOutPatientServiceImpl.getPatient();
    }
	
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<OpdOutPatient> getAllopdOutPatient() throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of inpatient", opdOutPatientServiceImpl.getAll());
		return opdOutPatientServiceImpl.getAllOpdOutPatient();
    }
	
	@CrossOrigin
	@RequestMapping(value = "patient/{patientId}", method = RequestMethod.GET, produces = "application/json")
    public Object getEmployeeById(@PathVariable String patientId) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of inpatient", opdOutPatientServiceImpl.getOutPatient(id));
		return opdOutPatientServiceImpl.getByPatientId(patientId);
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteOpdOutPatient(@PathVariable int id) {
		return opdOutPatientServiceImpl.deleteOpdOutPatient(id);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "docter/{docterId}", method = RequestMethod.GET, produces = "application/json")
    public Object getByDocterId(@PathVariable String docterId) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of inpatient", opdOutPatientServiceImpl.getOutPatient(id));
		return opdOutPatientServiceImpl.getByDocterId();
    }
	
	@CrossOrigin
	@RequestMapping(value = "/sd/{doctorId}",method = RequestMethod.GET,produces = "application/json")
	public Object getBydocterId(@PathVariable String doctorId){
		return opdOutPatientServiceImpl.getByDId(doctorId);
		
	}
}
