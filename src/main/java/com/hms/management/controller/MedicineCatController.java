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

import com.hms.management.model.MedicineCategoryModal;
import com.hms.management.repository.MedicineCategoryRepos;
@CrossOrigin
@RestController
@RequestMapping("medicineCat")
public class MedicineCatController {

	@Autowired
	private MedicineCategoryRepos medicineRepo;
	
	@PostMapping("add")
	public <T> T addMedicineCat(@RequestBody MedicineCategoryModal itemMedicineCat){
		System.out.println(itemMedicineCat);
		return (T) medicineRepo.save(itemMedicineCat);
	}
	@GetMapping("get")
	public <T> T getMedicineCat(){
		//System.out.println(itemMedicineCat);
		return  (T) medicineRepo.findAll();
	}
	@DeleteMapping("delete/{id}")
	public <T> T deleteMedicineCat(@PathVariable int id){
		//System.out.println(itemMedicineCat);
		medicineRepo.deleteById(id);
		Map<String,Object> map=new HashMap<>();
		map.put("status",1);
		map.put("id",id);
		return (T) map;
	}
}
