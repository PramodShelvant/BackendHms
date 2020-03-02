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
import com.hms.management.model.DeathRecord;
import com.hms.management.serviceimpl.DeathRecordServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("deathRecord")
public class DeathRecordController {

	@Autowired
	public DeathRecordServiceImpl deathRecordServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public DeathRecord addDeathRecord(@RequestBody DeathRecord deathRecord) {
		return deathRecordServiceImpl.addDeathRecord(deathRecord);
		
	}
	
	@CrossOrigin
    @RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<DeathRecord> getAllDeathRecord() throws RecordNotFoundException {
 		return deathRecordServiceImpl.getAllDeathRecord();
 }
	@CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public DeathRecord getByIdDeathRecord(@PathVariable int id) throws RecordNotFoundException {
 		return deathRecordServiceImpl.getComplainType(id);
 }
	
	    @CrossOrigin
	  	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	  	public Object deleteDeathRecord(@PathVariable int id) {
	  		return deathRecordServiceImpl.deleteDeathRecord(id);
	  		
	  	}	
}
