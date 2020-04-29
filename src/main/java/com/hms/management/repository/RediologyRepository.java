package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Pathology;
import com.hms.management.model.Rediology;

public interface RediologyRepository extends JpaRepository<Rediology, Integer>{

	public List<Rediology> findByTestName(String testName);

 
 
 
}
