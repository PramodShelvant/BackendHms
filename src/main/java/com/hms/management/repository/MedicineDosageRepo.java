package com.hms.management.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.MedicineDosageModal;

public interface MedicineDosageRepo extends JpaRepository<MedicineDosageModal, Integer> {
	@Query("select u.id as id , m.medicineCategory as medicineCategory,u.dosage as dosage"
			+ " from MedicineCategoryModal m inner join MedicineDosageModal u "
			+ "on u.medicineCategory=m.id")
	List<Map<String,Object>> fetchAll();

}
