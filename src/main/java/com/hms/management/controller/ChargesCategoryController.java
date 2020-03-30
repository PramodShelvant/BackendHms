package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ChargesCategory;
import com.hms.management.repository.ChargesCategoryRepo;

@RestController
@CrossOrigin
@RequestMapping("/chargesCategory")
public class ChargesCategoryController {
	@Autowired
	private ChargesCategoryRepo chargesCategoryRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody ChargesCategory b) {
		return (T) chargesCategoryRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) chargesCategoryRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		chargesCategoryRepo.deleteById(id);
		return (T) (""+id);

}
}
