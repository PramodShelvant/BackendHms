package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Department;
import com.hms.management.repository.DepartmentRepo;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Department b) {
		return (T) departmentRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) departmentRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		departmentRepo.deleteById(id);
		return (T) (""+id);
		
	}

}
