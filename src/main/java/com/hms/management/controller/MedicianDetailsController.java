package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.MedicianDetails;
import com.hms.management.serviceimpl.MedicianDetailsServiceImpl;
 
@RestController
@RequestMapping("/mediciandetails")
public class MedicianDetailsController {

	
	@Autowired
	public MedicianDetailsServiceImpl medicianDetailsServiceImpl;
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public MedicianDetails addMedicianDetails(@RequestBody MedicianDetails medicianDetails) {
		System.out.println(medicianDetails);
		return medicianDetailsServiceImpl.addMedicianDetails(medicianDetails);
	}
	
	@RequestMapping(value = "/{mid}", method = RequestMethod.GET, produces = "application/json")
	public MedicianDetails getMedicianDetails(@PathVariable int mid) throws RecordNotFoundException {
		return medicianDetailsServiceImpl.getMedicianDetails(mid);
	}
	    @CrossOrigin
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
		public Object deleteMedicianDetails(@PathVariable int id) {
			return medicianDetailsServiceImpl.deleteMedicianDetails(id);
			
		}
}
