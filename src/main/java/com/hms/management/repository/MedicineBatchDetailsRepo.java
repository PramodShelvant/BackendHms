package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.MedicineBatchDetails;

public interface MedicineBatchDetailsRepo extends JpaRepository<MedicineBatchDetails, Integer> {
	
	@Query("select u.id as id,u.batchNum as batchNum from MedicineBatchDetails u "
			+ "where pharmacyId=?1 AND SUBSTRING(u.expiryDate,1,10)>CURRENT_DATE AND u.availableQuantity>0")
	List<Object> fetchByPharmacyId(int id);

	List<MedicineBatchDetails> findByPharmacyId(int id);
	
	@Query("select p from MedicineBatchDetails p where "
			+ "SUBSTRING(p.expiryDate,1,10)<CURRENT_DATE")
	List<MedicineBatchDetails> fetchAllExpiry();

}
