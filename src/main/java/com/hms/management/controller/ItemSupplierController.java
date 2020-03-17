package com.hms.management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ItemSupplier;
import com.hms.management.repository.ItemSupplierRepo;

@RestController
@CrossOrigin
@RequestMapping("item-supplier")
public class ItemSupplierController {

	
	@Autowired
	private ItemSupplierRepo itemRepo;
	
	@PostMapping("add")
	public <T> T addSupplier(@RequestBody ItemSupplier itemsupplier){
		System.out.println(itemsupplier);
		return (T) itemRepo.save(itemsupplier);
	}
	@GetMapping("get")
	public <T> T getSupplier(){
		return  (T) itemRepo.findAll();
	}
	@DeleteMapping("delete/{id}")
	public <T> T deleteSupplier(@PathVariable int id){
		//System.out.println(itemsupplier);
		itemRepo.deleteById(id);
		Map<String,Object> map=new HashMap<>();
		map.put("status",1);
		map.put("id",id);
		return (T) map;
	}
}
