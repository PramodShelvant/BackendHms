package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Charges;

public interface ChargesRepository extends JpaRepository<Charges, Integer>{

	public List<Charges> findByOpdId(String opdId);

}
