package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Ambulance;
import com.hms.management.serviceimpl.AmbulanceServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("ambulancee")
public class AmbulanceController {

	
	@Autowired
	public AmbulanceServiceImpl ambulanceServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public Ambulance addAmbulance(@RequestBody Ambulance ambulance) {
		return ambulanceServiceImpl.addAmbulance(ambulance);
		
	}
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public List<Ambulance>  getAllAmbulance(){
		return ambulanceServiceImpl.getAll();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "update",method = RequestMethod.PUT,produces = "application/json")
	public Object updateAmbulance(@RequestBody Ambulance ambulance) {
		return ambulanceServiceImpl.updateAmbulance(ambulance);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE,produces = "application/json")
	public Object deleteAmbulance(@PathVariable int id) {
		return ambulanceServiceImpl.deleteAmbulance(id);
		
	}
}
