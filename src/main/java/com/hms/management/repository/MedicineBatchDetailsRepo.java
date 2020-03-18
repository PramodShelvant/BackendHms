package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.MedicineBatchDetails;

public interface MedicineBatchDetailsRepo extends JpaRepository<MedicineBatchDetails, Integer> {
	
	@Query("select u.id as id,u.batchNum as batchNum from MedicineBatchDetails u "
			+ "where pharmacyId=?1")
	List<Object> fetchByPharmacyId(int id);

}
