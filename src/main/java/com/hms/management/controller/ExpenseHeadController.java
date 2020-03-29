package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ExpenseHead;
import com.hms.management.repository.ExpenseHeadRepo;

@RestController
@CrossOrigin
@RequestMapping("/expenseHead")
public class ExpenseHeadController {
	@Autowired
	private ExpenseHeadRepo expenseHeadRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody ExpenseHead b) {
		return (T) expenseHeadRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) expenseHeadRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		expenseHeadRepo.deleteById(id);
		return (T) (""+id);
		
	}

}
