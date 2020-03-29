package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.BedGroup;
import com.hms.management.repository.BedGroupRepository;
@CrossOrigin
@RestController
@RequestMapping("/bedgroup")
public class BedGroupController {

	
	@Autowired
	public BedGroupRepository bedGroupRepository;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json")
	public BedGroup addBedGroup(@RequestBody BedGroup bedGroup) {
		return bedGroupRepository.save(bedGroup);
	}
	
	@GetMapping("/get")
	public <T> T fetchAll()
	{
		return (T) bedGroupRepository.fetchAll();
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id)
	{
		bedGroupRepository.deleteById(id);	
		return (T) (""+id);
	}
}
