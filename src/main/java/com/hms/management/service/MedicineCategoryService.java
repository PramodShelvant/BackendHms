package com.hms.management.service;

import com.hms.management.model.MedicineCategory;

public interface MedicineCategoryService {
	
	public MedicineCategory addMedicineCategory(MedicineCategory medicineCategory);

	public Object deleteMedicineCategory(int id);

}
