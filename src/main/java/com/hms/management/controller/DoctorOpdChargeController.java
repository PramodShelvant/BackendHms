package com.hms.management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.DoctorOpdCharge;
import com.hms.management.repository.DoctorOpdChargeRepository;
import com.hms.management.repository.OrganisationsChargesRepo;
@CrossOrigin
@RestController
@RequestMapping("/doctorOpdCharge")
public class DoctorOpdChargeController {
	@Autowired
	 private DoctorOpdChargeRepository docOpdCharge;
	@Autowired
	 private OrganisationsChargesRepo orgChargesRepo;
	
	@PostMapping("/add")
	public <T> T add(DoctorOpdCharge a) {
		Map<String,Object> map= new HashMap<>();
		DoctorOpdCharge d=docOpdCharge.save(a);
		orgChargesRepo.saveAll(a.getTpaCharges());
		return (T)map;
	}

}
