package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer>{
	
	@Query("select u.id as id, u.medicineName as medicineName from Pharmacy u "
			+ "where u.medicineCategoryId=?1")
	List<Object> findByMedicineCategory(int id);
	@Query("select new Map(p as pharmacy,s as medicine,SUM(m.availableQuantity) as availableQuantity) from Pharmacy p "
			+ "left join MedicineBatchDetails m on m.pharmacyId=p.id inner join MedicineCategoryModal s on "
			+ "s.id=p.medicineCategoryId group by m.pharmacyId")
	List<?> fetchPharmacy();

}
