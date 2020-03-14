package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.OpdDiagnosis;

public interface OpdDiagnosisRepository extends JpaRepository<OpdDiagnosis, Integer>{

	public List<OpdDiagnosis> findByOpdId(String opdId);

}
