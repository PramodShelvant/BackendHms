package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ReciptionistProfile;
import com.hms.management.serviceimpl.ReciptionistProfileServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("reciptionistprofile")
public class ReciptionistProfileController {

	
	@Autowired
	public ReciptionistProfileServiceImpl reciptionistProfileServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
	public ReciptionistProfile getReciptionistProfile(@PathVariable int id) throws RecordNotFoundException {
		return reciptionistProfileServiceImpl.getReciptionistProfile(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{userId}",method = RequestMethod.PUT,produces = "application/json")
	public Object changePassword(@PathVariable String userId, String oldPassword, String newPassword) {
		return reciptionistProfileServiceImpl.changePassword(oldPassword, newPassword, userId);
		
	}
}
