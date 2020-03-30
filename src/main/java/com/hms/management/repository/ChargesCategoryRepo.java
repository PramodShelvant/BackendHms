package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ChargesCategory;

public interface ChargesCategoryRepo extends JpaRepository<ChargesCategory, Integer> {

}
