package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.Bed;

public interface BedRepo extends JpaRepository<Bed, Integer>{
	
	@Query("SELECT new Map(b.id as id,b.name as name,t.name as bedTypeName,t.id as bedTypeId,"
			+ "g.id as bedGroupId,g.name as bedGroupName) FROM Bed b INNER JOIN "
			+ "BedGroup g ON g.id=b.bedGroupId INNER JOIN BedType t ON t.id=b.bedTypeId")
	List<?> fetchAll();

}
