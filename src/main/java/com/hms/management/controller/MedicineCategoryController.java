package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.MedicineCategory;
import com.hms.management.serviceimpl.MedicineCategoryServiceImpl;

@RestController
public class MedicineCategoryController {

	
	@Autowired
	public MedicineCategoryServiceImpl medicineCategoryServiceImpl;
	
	
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
      public MedicineCategory addMedicineCategory(@RequestBody MedicineCategory medicineCategory) {
		return medicineCategoryServiceImpl.addMedicineCategory(medicineCategory);
		
	}
}
