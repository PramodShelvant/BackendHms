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
import com.hms.management.model.Rediology;
import com.hms.management.serviceimpl.RediologyServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/rediology")
public class RediologyController {

	
	@Autowired
	public RediologyServiceImpl rediologyServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public Rediology addGenarateBill(@RequestBody Rediology rediology) throws RecordNotFoundException{
		return rediologyServiceImpl.addRediology(rediology);
		}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Rediology getRediologyById(@PathVariable int id) throws RecordNotFoundException {
 		return rediologyServiceImpl.getRediology(id);
    }
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}","doctor/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<Rediology> getAllRediology() throws RecordNotFoundException {
 		return rediologyServiceImpl.getAllRediology();
	}
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteRediology(@PathVariable int id) {
		return rediologyServiceImpl.deleteRediology(id);
		
	}
	 
}
