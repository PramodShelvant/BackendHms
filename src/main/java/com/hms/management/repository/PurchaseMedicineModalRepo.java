package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.PurchaseMedicineModal;

public interface PurchaseMedicineModalRepo extends JpaRepository<PurchaseMedicineModal, Integer>{
	@Query("select new Map(p as purchase,i as supplier) from PurchaseMedicineModal p inner join ItemSupplier i on "
			+ "p.supplierId=i.id")
	List<?> fetchAll();

}
