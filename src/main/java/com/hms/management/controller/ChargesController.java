package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Charges;
import com.hms.management.serviceimpl.ChargesServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("charges")
public class ChargesController {

	@Autowired
	public ChargesServiceImpl chargesServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public Charges addcharges(@RequestBody Charges charges) {
		return chargesServiceImpl.addCharges(charges);
		}
	
	@CrossOrigin
	@RequestMapping(value = "/{opdId}",method = RequestMethod.GET,produces = "application/json")
	public Object getCharges(@PathVariable String opdId) {
		return chargesServiceImpl.getCharges(opdId);
	}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public List<Charges>  getAll(){
		return chargesServiceImpl.getAll();
		
	}
}
