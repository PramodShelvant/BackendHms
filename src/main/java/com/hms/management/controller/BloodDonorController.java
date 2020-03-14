package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodDonor;
import com.hms.management.serviceimpl.BloodDonorServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/blooddonor")
public class BloodDonorController {

	
	@Autowired
	public BloodDonorServiceImpl bloodDonorServiceImpl;
	
	
	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = "/", method = RequestMethod.POST, produces =
	 * "application/json") public BloodDonor addBloodDonor(@RequestBody BloodDonor
	 * bloodDonor) throws RecordNotFoundException{ //Map<String, Object> map=new
	 * HashMap<String, Object>(); //BloodDonor updated =
	 * bloodDonorServiceImpl.addBloodDonor(bloodDonor); // map.put("data saved", new
	 * ResponseEntity<BloodDonor>(updated, new HttpHeaders(), HttpStatus.OK));
	 * return bloodDonorServiceImpl.addBloodDonor(bloodDonor); }
	 */
	
	 @RequestMapping(value = "/", method = RequestMethod.POST, produces ="application/json")
    public ResponseEntity<BloodDonor> createOrUpdateEmployee(BloodDonor bloodDonor)
            throws RecordNotFoundException {
    	BloodDonor updated = bloodDonorServiceImpl.addBloodDonor(bloodDonor);
return new ResponseEntity<BloodDonor>(updated, new HttpHeaders(), HttpStatus.OK);
}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public BloodDonor getBloodDonorById(@PathVariable int id) throws RecordNotFoundException {
 		return bloodDonorServiceImpl.getBloodDonor(id);
    }
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<BloodDonor> getBloodDonorAll() throws RecordNotFoundException {
 		return bloodDonorServiceImpl.getAllBloodDonor();
    }
	@CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  	public Object deleteBloodDonor(@PathVariable int id) {
         return bloodDonorServiceImpl.deleteBloodDonor(id);
  		
  	}	
	
	@CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
  	public Object updateBloodDonor(@RequestBody BloodDonor bloodDonor) {
         return bloodDonorServiceImpl.updateBloodDonor(bloodDonor);
	}
}
