package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.MedicineCategory;
import com.hms.management.repository.MedicineCategoryRepository;
import com.hms.management.service.MedicineCategoryService;

@Service
public class MedicineCategoryServiceImpl implements MedicineCategoryService{

	
	@Autowired
	public MedicineCategoryRepository medicineCategoryRepository;
	
	@Override
	public MedicineCategory addMedicineCategory(MedicineCategory medicineCategory) {
 		return medicineCategoryRepository.save(medicineCategory);
	}

}
