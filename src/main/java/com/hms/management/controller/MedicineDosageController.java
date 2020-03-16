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

import com.hms.management.model.MedicineDosageModal;
import com.hms.management.repository.MedicineDosageRepo;
@CrossOrigin
@RestController
@RequestMapping("medicinedosage")
public class MedicineDosageController {

	@Autowired
	private MedicineDosageRepo medicineRepo;
	
	@PostMapping("add")
	public <T> T addMedicineDosage(@RequestBody MedicineDosageModal itemMedicineDosage){
		System.out.println(itemMedicineDosage);
		return (T) medicineRepo.save(itemMedicineDosage);
	}
	@GetMapping("get")
	public <T> T getMedicineDosage(){
		//System.out.println(itemMedicineDosage);
		return  (T) medicineRepo.fetchAll();
	}
	@DeleteMapping("delete/{id}")
	public <T> T deleteMedicineDosage(@PathVariable int id){
		medicineRepo.deleteById(id);
		Map<String,Object> map=new HashMap<>();
		map.put("status",1);
		map.put("id",id);
		return (T) map;
	}
}
