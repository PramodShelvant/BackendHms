package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.BedGroup;

public interface BedGroupRepository extends JpaRepository<BedGroup, Integer>{
	@Query("SELECT new Map(b.id as id,b.name as name,b.description as description"
			+ ",f.id as floorId,f.name as floorName) FROM BedGroup b INNER JOIN Floor f ON f.id=b.floorId")
	List<?> fetchAll();

}
