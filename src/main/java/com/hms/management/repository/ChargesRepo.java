package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Charges;

public interface ChargesRepo extends JpaRepository<Charges, Integer>{

}
