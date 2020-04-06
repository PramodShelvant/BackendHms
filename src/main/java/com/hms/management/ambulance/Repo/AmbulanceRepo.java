package com.hms.management.ambulance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.ambulance.model.Ambulance;

public interface AmbulanceRepo extends JpaRepository<Ambulance, Integer> {

}
