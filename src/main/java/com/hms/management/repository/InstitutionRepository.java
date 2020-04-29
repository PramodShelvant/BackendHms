package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, String>{

}
