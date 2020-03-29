package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ItemStore;
import com.hms.management.repository.ItemStoreRepo;

@RestController
@CrossOrigin
@RequestMapping("/itemStore")
public class ItemStoreController {
	@Autowired
	private ItemStoreRepo itemStoreRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody ItemStore b) {
		return (T) itemStoreRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) itemStoreRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		itemStoreRepo.deleteById(id);
		return (T) (""+id);
		
	}
	
	
	


}
