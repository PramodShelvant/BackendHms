package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer>{

}
