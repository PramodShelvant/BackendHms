package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Bed;

public interface BedRepo extends JpaRepository<Bed, Integer>{

}
