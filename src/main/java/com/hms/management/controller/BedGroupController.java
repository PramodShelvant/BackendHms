package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.BedGroup;
import com.hms.management.serviceimpl.BedGroupServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("bedGroup")
public class BedGroupController {

	
	@Autowired
	public BedGroupServiceImpl bedGroupServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public BedGroup addBedGroup(BedGroup bedGroup) {
		return bedGroupServiceImpl.addBedGroup(bedGroup);
		
	}
}
