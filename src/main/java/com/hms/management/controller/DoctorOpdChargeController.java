package com.hms.management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ComplaintType;
import com.hms.management.model.DoctorOpdCharge;
import com.hms.management.repository.DoctorOpdChargeRepository;
import com.hms.management.repository.OrganisationsChargesRepo;
@CrossOrigin
@RestController
@RequestMapping("/doctorOpdCharge")
public class DoctorOpdChargeController {
	@Autowired
	 private DoctorOpdChargeRepository docOpdCharge;
	@PostMapping("/add")
	public <T> T add(@RequestBody DoctorOpdCharge b) {
		System.out.println(b);
		return (T) docOpdCharge.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) docOpdCharge.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		docOpdCharge.deleteById(id);
		return (T) (""+id);
		
	}

}
