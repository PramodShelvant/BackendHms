package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.IncomeHead;
import com.hms.management.repository.IncomeHeadRepo;

@RestController
@CrossOrigin
@RequestMapping("/incomeHead")
public class IncomeHeadController {
	@Autowired
	private IncomeHeadRepo incomeHeadRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody IncomeHead b) {
		return (T) incomeHeadRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) incomeHeadRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		incomeHeadRepo.deleteById(id);
		return (T) (""+id);
		
	}

}
