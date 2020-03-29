package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ItemCategory;
import com.hms.management.repository.ItemCategoryRepo;

@RestController
@CrossOrigin
@RequestMapping("/itemCategory")
public class ItemCategoryController {
	
	@Autowired
	private ItemCategoryRepo itemCategoryRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody ItemCategory b) {
		return (T) itemCategoryRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) itemCategoryRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		itemCategoryRepo.deleteById(id);
		return (T) (""+id);
		
	}
	
	
	


}
