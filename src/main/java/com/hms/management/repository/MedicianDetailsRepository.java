package com.hms.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.MedicianDetails;

public interface MedicianDetailsRepository extends JpaRepository<MedicianDetails, Integer>{

	Optional<MedicianDetails> findByMid(int mid);

}
